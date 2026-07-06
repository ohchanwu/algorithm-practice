#!/usr/bin/env python3
"""Fuzz harness for 모험가 길드 (이코테, greedy).

Generates random fear-level lists, computes the true maximum number of groups
with an INDEPENDENT exhaustive oracle (it searches over every possible way to
form groups — NOT the greedy rule), runs the solution on each, and reports any
mismatch. N is kept small so the exhaustive search stays cheap. Seeded for
reproducibility.

The solution under test is the newest file next to this harness, by naming
scheme: sol_<N>_<YYMMDD>.py (newest = latest date, then highest N), else the
older attempt_<N>.py, else prac.py.

Run from anywhere:  python3 "problems/이코테/그리디-모험가-길드/fuzz.py"
"""
import glob
import os
import random
import re
import subprocess
import sys
from functools import lru_cache

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


def expected(fears):
    """Independent oracle: true maximum number of valid groups.

    Exhaustively searches over every way to carve disjoint groups out of the
    adventurers, where a group of size s may only contain members with fear <= s.
    Unrelated to the greedy accumulation the intended solution uses.
    """
    fears = tuple(sorted(fears))
    n = len(fears)

    @lru_cache(maxsize=None)
    def rec(mask):
        if mask == 0:
            return 0
        avail = [i for i in range(n) if mask & (1 << i)]
        i0 = avail[0]
        m = len(avail)
        best = rec(mask & ~(1 << i0))  # leave i0 ungrouped
        for sub in range(1 << m):
            if not (sub & 1):  # every formed group must contain i0
                continue
            idxs = [avail[j] for j in range(m) if sub & (1 << j)]
            if len(idxs) >= max(fears[k] for k in idxs):
                nm = mask
                for k in idxs:
                    nm &= ~(1 << k)
                best = max(best, 1 + rec(nm))
        return best

    return rec((1 << n) - 1)


def run_solution(fears):
    payload = f"{len(fears)}\n{' '.join(map(str, fears))}\n"
    out = subprocess.run(
        [sys.executable, SOLUTION], input=payload, capture_output=True, text=True
    )
    return out.stdout.strip()


def main():
    print(f"solution under test: {os.path.basename(SOLUTION)}")
    fails = []
    total = 0
    # keep N small: the exhaustive oracle is exponential
    for n in range(1, 9):
        for _ in range(80):
            # fear up to n+1 so "fear exceeds available members" cases appear
            fears = [random.randint(1, n + 1) for _ in range(n)]
            total += 1
            exp, got = str(expected(fears)), run_solution(fears)
            if got != exp:
                fails.append((fears, exp, got))
    print(f"ran {total} random cases")
    print(f"failures: {len(fails)}")
    for fears, exp, got in fails[:20]:
        print(f"  FAIL fears={fears} exp={exp} got={got}")
    return 1 if fails else 0


if __name__ == "__main__":
    sys.exit(main())
