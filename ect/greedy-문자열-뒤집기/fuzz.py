#!/usr/bin/env python3
"""Fuzz harness for 문자열 뒤집기 (Baekjoon Online Judge problem 1439, greedy).

Generates random 0/1 strings, computes the expected answer with an INDEPENDENT
reference function (written separately from the solution), runs the solution on
each, and reports any mismatch. Seeded for reproducibility.

The solution under test is the newest file next to this harness, by naming
scheme: sol_<N>_<YYMMDD>.py (newest = latest date, then highest N), else the
older attempt_<N>.py, else prac.py.

Run from anywhere:  python3 "problems/이코테/그리디-문자열-뒤집기/fuzz.py"
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


def expected(s):
    """Independent reference: min(#groups of 0s, #groups of 1s)."""
    g0 = g1 = 0
    prev = ""
    for c in s:
        if c != prev:
            if c == "0":
                g0 += 1
            else:
                g1 += 1
        prev = c
    return min(g0, g1)


def run_solution(s):
    out = subprocess.run(
        [sys.executable, SOLUTION], input=s + "\n", capture_output=True, text=True
    )
    return out.stdout.strip()


def main():
    print(f"solution under test: {os.path.basename(SOLUTION)}")
    fails = []
    total = 0

    # 1) random strings, varied length and digit ratio
    for length in range(1, 61):
        for _ in range(40):
            p = random.choice([0.1, 0.3, 0.5, 0.7, 0.9])
            s = "".join("1" if random.random() < p else "0" for _ in range(length))
            total += 1
            exp, got = str(expected(s)), run_solution(s)
            if got != exp:
                fails.append((s, exp, got))

    # 2) a few large random strings
    for _ in range(5):
        s = "".join(random.choice("01") for _ in range(100000))
        total += 1
        exp, got = str(expected(s)), run_solution(s)
        if got != exp:
            fails.append(("<len100000>", exp, got))

    print(f"ran {total} random cases")
    print(f"failures: {len(fails)}")
    for s, exp, got in fails[:20]:
        disp = s if len(s) <= 40 else s[:40] + f"...(len {len(s)})"
        print(f"  FAIL in={disp} exp={exp} got={got}")
    return 1 if fails else 0


if __name__ == "__main__":
    sys.exit(main())
