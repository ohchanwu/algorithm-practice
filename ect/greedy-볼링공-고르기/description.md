# 볼링공 고르기 — 이것이 취업을 위한 코딩 테스트다 (이코테)

> Source: the book 이것이 취업을 위한 코딩 테스트다 (이코테), greedy chapter.
> Not a numbered Baekjoon problem.

## Method used

Greedy (그리디 / 탐욕법)

> Note for future sessions: this field records the technique for a problem the
> user filed under the greedy chapter. Never volunteer the actual solution idea
> as a hint while they are still solving — see the golden rules in `../../CLAUDE.md`.

## Problem statement (문제)

A와 B 두 사람이 함께 볼링을 치려고 한다. 두 사람은 서로 **무게가 다른** 볼링공을
고르려 한다. 볼링공은 총 `N`개가 있고, 각 볼링공에는 `1`부터 `M`까지의 정수로
표현되는 무게가 적혀 있다. `N`개의 공 중에서 A와 B가 각각 하나씩, 무게가 서로
다른 두 공을 고르는 경우의 수를 구하라. 단, 같은 두 공을 누가 골랐는지는 구분하지
않는다 — 즉 공의 **쌍을 순서 없이** 센다.

예: `N=5, M=3`, 무게가 `1 3 2 3 2` 이면 답은 `8`이다.

## Input / output contract

- **Input:** 두 줄.
  - 첫째 줄: 공의 개수 `N`, 공의 최대 무게 `M` (공백으로 구분).
  - 둘째 줄: 각 공의 무게 `N`개가 공백으로 구분되어 주어진다 (각 무게는 `1`–`M`).
- **Output:** 두 사람이 고를 수 있는 경우의 수 (정수 한 개).
- The solution reads `n, m = input().split()` then the weights. Run a single
  case from inside this folder (use your latest `sol_<N>_<YYMMDD>.py`):
  `cd "problems/이코테/그리디-볼링공-고르기" && python3 sol_1_260601.py < input.txt`

## Constraints

- `1 ≤ N ≤ 1,000`.
- `1 ≤ M ≤ 10`, and each weight is `1`–`M`.

## Verification oracle (test input → expected output)

Expected values were computed two independent ways — a direct count of unordered
pairs with different weights, and the formula `C(N,2) − Σ C(countₓ,2)` — and they
agree. See `fuzz.py`. **Encourage the user to predict the answer themselves
before peeking**, and don't explain *why* a value is what it is.

Each case is two input lines: `N M`, then the weights.

| N M  | weights (line 2)    | expected | what it stresses                       |
|------|---------------------|----------|----------------------------------------|
| 1 1  | `1`                 | `0`      | one ball → no pair                     |
| 2 1  | `1 1`               | `0`      | two balls, same weight                 |
| 2 2  | `1 2`               | `1`      | the single valid pair                  |
| 3 1  | `1 1 1`             | `0`      | all same weight (duplicate-heavy)      |
| 3 3  | `1 2 3`             | `3`      | all distinct → C(N,2)                  |
| 4 1  | `2 2 2 2`           | `0`      | all same                               |
| 4 2  | `1 1 2 2`           | `4`      | two of each weight                     |
| 6 2  | `1 1 1 2 2 2`       | `9`      | 3+3 split                              |
| 5 5  | `1 2 3 4 5`         | `10`     | all distinct                           |
| 5 3  | `1 3 2 3 2`         | `8`      | the book example                       |
| 8 5  | `1 5 4 3 2 4 5 2`   | `25`     | the active `input.txt` case            |

### Large / performance cases

Run these from inside this problem folder so `input.txt` lands here:

```
python3 -c "print(1000, 1); print(' '.join(['1']*1000))" > input.txt        # all weight 1 → 0
python3 -c "print(1000, 2); print(' '.join(['1','2']*500))" > input.txt      # 500 each → 250000
```

## Strongest bug-catchers for this problem

In rough order of how often they break a wrong solution:

1. **Many duplicate weights / all the same weight** (`1 1 1`, `2 2 2 2`) — the
   answer is `0`; solutions that mishandle duplicates (or mutate a list while
   counting over it) trip here.
2. **All distinct weights** (`1 2 3`, `1 2 3 4 5`) → exactly `C(N,2)`.
3. **Single ball** → `0` (no pair exists).
4. **N = 2 boundary** — exactly one possible pair.
5. **Large N** (performance) — `N = 1000`; an approach that materializes every
   pair is `O(N²)` (~500k pairs) and may be slow.

## Random / fuzz testing

`fuzz.py` (next to this file) generates random weight lists (small `M` so
duplicate weights collide often), computes the answer with an **independent
direct pair-count oracle** (not the book's counting trick), runs the solution on
each, and reports mismatches. `N` is kept small so the oracle stays cheap. It
auto-tests the newest `sol_<N>_<YYMMDD>.py` next to it. Run from the repo root:

```
python3 "problems/이코테/그리디-볼링공-고르기/fuzz.py"
```

Seeded, so reproducible. Bump the loop counts to widen coverage.

## Test history

- **2026-06-01:** Folder harness set up. All 11 hand-picked cases + 2 performance
  cases cross-verified two independent ways (direct pair count vs. the
  `C(N,2) − Σ C(countₓ,2)` formula) — all consistent.
