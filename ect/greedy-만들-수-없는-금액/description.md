# 만들 수 없는 금액 — 이것이 취업을 위한 코딩 테스트다 (이코테)

> Source: the book 이것이 취업을 위한 코딩 테스트다 (이코테), greedy chapter.
> Not a numbered Baekjoon problem.

## Method used

Greedy (그리디 / 탐욕법)

> Note for future sessions: this field records the technique for an
> already-chosen problem. Never volunteer it as a hint while the user is still
> working — see the golden rules in `../../CLAUDE.md`.

## Problem statement (문제)

`N`개의 동전이 주어진다. 각 동전은 양의 정수로 표현되는 화폐 단위를 가지며,
같은 값의 동전이 여러 개 있을 수 있다. 이 동전들 중 일부 또는 전부를 골라 그
합으로 어떤 금액들을 만들 수 있다. 이때 **만들 수 없는 양의 정수 금액 중 가장
작은 값**을 구하라.

예: 동전이 `3, 2, 1, 1, 9` 이면 1원부터 7원까지는 만들 수 있지만 8원은 만들 수
없으므로 답은 `8`이다.

## Input / output contract

- **Input:** 두 줄.
  - 첫째 줄: 동전의 개수 `N`.
  - 둘째 줄: `N`개의 동전 화폐 단위가 공백으로 구분되어 주어진다.
- **Output:** 만들 수 없는 양의 정수 금액 중 최솟값 (정수 한 개).
- Your solution reads `n = int(input())` then `coins = list(map(int, input().split()))`.
  Run a single case from inside this folder (use your latest `attempt_<N>.py`):
  `cd "problems/이코테/그리디-만들-수-없는-금액" && python3 attempt_1.py < input.txt`

## Constraints

- `1 ≤ N ≤ 1,000`.
- each coin value `1 ≤ value ≤ 1,000,000`.

## Verification oracle (test input → expected output)

Expected values were computed two independent ways (brute-force over every
subset, and a subset-sum reachability table) — see `fuzz.py`. They are
trustworthy ground truth. **Encourage the user to predict the answer themselves
before peeking**, and do not explain _why_ a value is what it is (that leaks the
method).

Each case is two input lines: `N`, then the coins. The table shows the coins
inline for brevity.

| N   | coins (line 2) | expected | what it stresses                             |
| --- | -------------- | -------- | -------------------------------------------- |
| 1   | `1`            | `2`      | single coin equal to 1                       |
| 1   | `2`            | `1`      | single coin > 1 → can't even make 1          |
| 2   | `1 1`          | `3`      | duplicates, all ones                         |
| 3   | `2 3 4`        | `1`      | no coin equal to 1 → answer is 1             |
| 3   | `1 2 3`        | `7`      | contiguous build-up 1..6                     |
| 2   | `1 3`          | `2`      | gap right after 1                            |
| 2   | `1 100`        | `2`      | large jump after 1                           |
| 5   | `3 2 1 1 9`    | `8`      | the book example, **given UNSORTED**         |
| 5   | `9 2 1 3 1`    | `8`      | same multiset, different order (order-proof) |
| 5   | `1 1 1 1 1`    | `6`      | all ones                                     |
| 3   | `1 2 2`        | `6`      | duplicate in the middle                      |
| 4   | `1 2 4 8`      | `16`     | powers of two → answer is 2^k                |

### Large / performance cases (generate, don't paste by hand)

Run these from inside this problem folder so `input.txt` lands here:

```
python3 -c "print(1000); print(' '.join(['1']*1000))" > input.txt         # expected 1001
python3 -c "print(1000); print(' '.join(['2']*1000))" > input.txt         # expected 1
python3 -c "print(20); print(' '.join(str(2**i) for i in range(20)))" > input.txt  # expected 1048576
```

## Strongest bug-catchers for this problem

In rough order of how often they break a wrong solution:

1. **Unsorted input** — the single most common trap. The book's own example
   `3 2 1 1 9` is unsorted; a solution that assumes sorted input gets this wrong.
   Always keep at least one unsorted case in rotation.
2. **No coin equal to 1** (`2 3 4`) — the answer must be `1`.
3. **Duplicate coins** (`1 1`, `1 2 2`).
4. **Single coin** — both `=1` and `>1`.
5. **Large N** (performance) — the all-ones case gives the clean answer `N+1`.

## Random / fuzz testing

`fuzz.py` (next to this file) generates random coin multisets, computes the
expected answer with an **independent brute-force subset-sum oracle** (not the
greedy method), runs your solution on each, and reports mismatches. It auto-tests
the highest-numbered `attempt_<N>.py` next to it. Coin values are kept small on
purpose so the brute-force oracle stays cheap; small values still exercise every
structural case (gaps, duplicates, no-1, unsorted). Run from the repo root:

```
python3 "problems/이코테/그리디-만들-수-없는-금액/fuzz.py"
```

Seeded, so reproducible. Bump the loop counts to widen coverage.

## Test history

- **2026-05-30:** Folder created. All 12 hand-picked cases + 3 performance cases
  cross-verified two independent ways (subset enumeration vs. subset-sum DP) —
  all consistent. The fuzz harness is ready but has not been run against a real
  solution yet — there was no solution file in this folder at creation time.
