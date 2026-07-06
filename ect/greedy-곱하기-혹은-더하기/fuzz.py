#!/usr/bin/env python3
"""Fuzz harness for 곱하기 혹은 더하기 (이코테, greedy).

Generates random digit strings, computes the true maximum with an INDEPENDENT
brute-force oracle (tries every +/x choice, evaluated left-to-right — NOT the
greedy rule), runs the solution on each, and reports any mismatch. String lengths
are kept small so the brute force stays cheap. Digits are biased toward 0/1 so the
"must add when an operand is <= 1" cases come up often. Seeded for reproducibility.

The solution under test is the newest file next to this harness, by naming
scheme: sol_<N>_<YYMMDD>.py (newest = latest date, then highest N), else the
older attempt_<N>.py, else prac.py.

Run from anywhere:  python3 "problems/이코테/그리디-곱하기-혹은-더하기/fuzz.py"
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

# pool weighted toward 0 and 1 to exercise the add-branch
POOL = "0011" + "23456789"


def expected(s):
    """Independent oracle: true maximum over every +/x choice, left-to-right."""
    d = [int(c) for c in s]
    n = len(d)
    best = None
    for mask in range(1 << (n - 1)):
        res = d[0]
        for i in range(1, n):
            if (mask >> (i - 1)) & 1:
                res += d[i]
            else:
                res *= d[i]
        best = res if best is None else max(best, res)
    return best


def run_solution(s):
    out = subprocess.run(
        [sys.executable, SOLUTION], input=s + "\n", capture_output=True, text=True
    )
    return out.stdout.strip()


def main():
    print(f"solution under test: {os.path.basename(SOLUTION)}")
    fails = []
    total = 0
    for length in range(1, 14):
        for _ in range(100):
            s = "".join(random.choice(POOL) for _ in range(length))
            total += 1
            exp, got = str(expected(s)), run_solution(s)
            if got != exp:
                fails.append((s, exp, got))
    print(f"ran {total} random cases")
    print(f"failures: {len(fails)}")
    for s, exp, got in fails[:20]:
        print(f"  FAIL S={s} exp={exp} got={got}")
    return 1 if fails else 0


if __name__ == "__main__":
    sys.exit(main())
