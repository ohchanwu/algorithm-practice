#!/usr/bin/env python3
"""Fuzz harness for 볼링공 고르기 (이코테, greedy).

Generates random weight lists (small M so duplicate weights collide often),
computes the answer with an INDEPENDENT direct pair-count oracle (count unordered
pairs with different weights — NOT the book's counting trick), runs the solution
on each, and reports any mismatch. N is kept small so the oracle stays cheap.
Seeded for reproducibility.

The solution under test is the newest file next to this harness, by naming
scheme: sol_<N>_<YYMMDD>.py (newest = latest date, then highest N), else the
older attempt_<N>.py, else prac.py.

Run from anywhere:  python3 "problems/이코테/그리디-볼링공-고르기/fuzz.py"
"""
import glob
import os
import random
import re
import subprocess
import sys

HERE = os.path.dirname(os.path.abspath(__file__))


def _find_solution():
    """Locate the solution file sitting next to this harness.

    Naming scheme, newest wins: sol_<N>_<YYMMDD>.py ranked by (date, N).
    Falls back to the older attempt_<N>.py (highest N), then prac.py. Any
    sol_*.py that does not fit the sol_<N>_<YYMMDD>.py pattern is skipped with a
    warning so it is not silently ignored.
    """
    sols, skipped = [], []
    for path in glob.glob(os.path.join(HERE, "sol_*.py")):
        name = os.path.basename(path)
        m = re.fullmatch(r"sol_(\d+)_(\d+)\.py", name)
        if m:
            sols.append(((int(m.group(2)), int(m.group(1))), path))  # ((date, N), path)
        else:
            skipped.append(name)
    if skipped:
        print(
            "warning: ignoring non-conforming sol_*.py file(s): "
            + ", ".join(sorted(skipped)),
            file=sys.stderr,
        )
    if sols:
        return max(sols)[1]
    attempts = []
    for path in glob.glob(os.path.join(HERE, "attempt_*.py")):
        m = re.fullmatch(r"attempt_(\d+)\.py", os.path.basename(path))
        if m:
            attempts.append((int(m.group(1)), path))
    if attempts:
        return max(attempts)[1]
    fallback = os.path.join(HERE, "prac.py")
    if os.path.exists(fallback):
        return fallback
    sys.exit(
        "no sol_<N>_<YYMMDD>.py, attempt_<N>.py, or prac.py found next to this fuzz.py"
    )


SOLUTION = _find_solution()

random.seed(42)  # reproducible


def expected(weights):
    """Independent oracle: count unordered pairs of balls with different weight."""
    c = 0
    for i in range(len(weights)):
        for j in range(i + 1, len(weights)):
            if weights[i] != weights[j]:
                c += 1
    return c


def run_solution(weights, m):
    payload = f"{len(weights)} {m}\n{' '.join(map(str, weights))}\n"
    out = subprocess.run(
        [sys.executable, SOLUTION], input=payload, capture_output=True, text=True
    )
    return out.stdout.strip()


def main():
    print(f"solution under test: {os.path.basename(SOLUTION)}")
    fails = []
    total = 0
    for n in range(1, 16):
        for _ in range(100):
            cap = random.randint(1, 5)  # small range => duplicate weights collide often
            weights = [random.randint(1, cap) for _ in range(n)]
            m = max(weights)  # M = the largest weight present (legal under any reading of M)
            total += 1
            exp, got = str(expected(weights)), run_solution(weights, m)
            if got != exp:
                fails.append((weights, m, exp, got))
    print(f"ran {total} random cases")
    print(f"failures: {len(fails)}")
    for weights, m, exp, got in fails[:20]:
        print(f"  FAIL N={len(weights)} M={m} weights={weights} exp={exp} got={got}")
    return 1 if fails else 0


if __name__ == "__main__":
    sys.exit(main())
