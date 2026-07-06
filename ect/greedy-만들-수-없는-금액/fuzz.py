#!/usr/bin/env python3
"""Fuzz harness for 만들 수 없는 금액 (이코테, greedy).

Generates random coin multisets, computes the expected answer with an INDEPENDENT
brute-force subset-sum oracle (NOT the greedy trick), runs the solution on each,
and reports any mismatch. Coin values are kept small on purpose so the brute-force
oracle stays cheap — small values still exercise every structural case (gaps,
duplicates, no-1, unsorted). Seeded for reproducibility.

The solution under test is the newest file next to this harness, by naming
scheme: sol_<N>_<YYMMDD>.py (newest = latest date, then highest N), else the
older attempt_<N>.py, else prac.py.

Run from anywhere:  python3 "problems/이코테/그리디-만들-수-없는-금액/fuzz.py"
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


def expected(coins):
    """Independent oracle: smallest positive integer that is NOT a subset sum.

    Uses subset-sum reachability (a set DP), which is unrelated to the greedy
    accumulation trick the intended solution uses.
    """
    reachable = {0}
    for c in coins:
        reachable |= {r + c for r in reachable}
    m = 1
    while m in reachable:
        m += 1
    return m


def run_solution(coins):
    payload = f"{len(coins)}\n{' '.join(map(str, coins))}\n"
    out = subprocess.run(
        [sys.executable, SOLUTION], input=payload, capture_output=True, text=True
    )
    return out.stdout.strip()


def main():
    print(f"solution under test: {os.path.basename(SOLUTION)}")
    fails = []
    total = 0

    for n in range(1, 15):
        for _ in range(150):
            coins = [random.randint(1, 20) for _ in range(n)]
            total += 1
            exp, got = str(expected(coins)), run_solution(coins)
            if got != exp:
                fails.append((coins, exp, got))

    print(f"ran {total} random cases")
    print(f"failures: {len(fails)}")
    for coins, exp, got in fails[:20]:
        disp = coins if len(coins) <= 15 else coins[:15] + ["..."]
        print(f"  FAIL coins={disp} exp={exp} got={got}")
    return 1 if fails else 0


if __name__ == "__main__":
    sys.exit(main())
