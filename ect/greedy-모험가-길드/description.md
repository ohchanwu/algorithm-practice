# 모험가 길드 — 이것이 취업을 위한 코딩 테스트다 (이코테)

> Source: the book 이것이 취업을 위한 코딩 테스트다 (이코테), greedy chapter.
> Not a numbered Baekjoon problem.

## Method used

Greedy (그리디 / 탐욕법)

> Note for future sessions: this field records the technique for a problem the
> user has filed under the greedy chapter. Never volunteer the actual solution
> idea (how to form the groups) as a hint while they are still solving — see the
> golden rules in `../../CLAUDE.md`.

## Problem statement (문제)

`N`명의 모험가가 있고, 각 모험가는 **공포도**라는 양의 정수 값을 가진다. 공포도가
`X`인 모험가는 반드시 `X`명 이상으로 이루어진 그룹에 속해야만 모험을 떠날 수
있다. 모험을 떠나는 그룹의 수를 최대로 만들고 싶다. 모든 모험가가 그룹에 속할
필요는 없다(일부는 그룹에 넣지 않아도 된다). 만들 수 있는 모험가 그룹 수의
**최댓값**을 출력하라.

예: 공포도가 `2, 3, 1, 2, 2` 인 모험가 5명이 있을 때, 공포도 1인 모험가로 1명짜리
그룹 하나, 공포도 2인 모험가 둘로 2명짜리 그룹 하나를 만들 수 있으므로 최대 `2`개
그룹이 가능하다. (공포도 3인 모험가는 남는다.)

## Input / output contract

- **Input:** 두 줄.
  - 첫째 줄: 모험가의 수 `N`.
  - 둘째 줄: 각 모험가의 공포도 `N`개가 공백으로 구분되어 주어진다.
- **Output:** 만들 수 있는 그룹 수의 최댓값 (정수 한 개).
- The solution reads `n = int(input())` then the fear levels with
  `input().split()`. Run a single case from inside this folder (use your latest
  `attempt_<N>.py`):
  `cd "problems/이코테/그리디-모험가-길드" && python3 attempt_1.py < input.txt`

## Constraints

- `1 ≤ N ≤ 100,000`.
- each fear level `1 ≤ 공포도 ≤ N`.

## Verification oracle (test input → expected output)

Expected values were computed **three** independent ways and all agree: an
exhaustive true-maximum search over every way to form groups, a dynamic-program
on the sorted list, and the greedy rule — see `fuzz.py`. **Encourage the user to
predict the answer themselves before peeking**, and don't explain *why* a value
is what it is (that leaks the method).

Each case is two input lines: `N`, then the fear levels.

| N | fears (line 2)  | expected | what it stresses                              |
|---|-----------------|----------|-----------------------------------------------|
| 1 | `1`             | `1`      | single adventurer, fear 1 → one group         |
| 1 | `2`             | `0`      | fear exceeds the only member → no group       |
| 2 | `1 2`           | `1`      | one group + one leftover                      |
| 2 | `2 2`           | `1`      | exactly fills a 2-member group                |
| 3 | `1 1 1`         | `3`      | all fear 1 → three groups                     |
| 3 | `2 2 2`         | `1`      | one group of 2, one leftover                  |
| 3 | `3 3 3`         | `1`      | one full group of 3                           |
| 4 | `1 2 2 3`       | `2`      | mixed sizes                                   |
| 5 | `2 3 1 2 2`     | `2`      | the book example, **given UNSORTED**          |
| 5 | `5 5 5 5 5`     | `1`      | all at the max fear                           |
| 6 | `1 1 1 1 1 1`   | `6`      | all ones                                      |
| 7 | `3 2 3 4 1 2 2` | `3`      | larger mixed, unsorted                        |

### Large / performance cases

Run these from inside this problem folder so `input.txt` lands here:

```
python3 -c "print(100000); print(' '.join(['1']*100000))" > input.txt   # expected 100000
python3 -c "print(100000); print(' '.join(['2']*100000))" > input.txt   # expected 50000
python3 -c "print(100000); print(' '.join(['5']*100000))" > input.txt   # expected 20000
```

## Strongest bug-catchers for this problem

In rough order of how often they break a wrong solution:

1. **Input order is arbitrary** — the book's own example `2 3 1 2 2` is unsorted.
   Always keep at least one unsorted case in rotation.
2. **An adventurer whose fear exceeds the members available** (`2` alone, or a
   `5` at the end of a short list) — they simply can't form a group and become a
   leftover, contributing `0`.
3. **Leftovers don't count** — not every adventurer must be placed; the answer is
   the number of *valid groups*, not how many people were used.
4. **All the same fear** (`5 5 5 5 5`, `2 2 2`) → `N // fear` groups.
5. **Large N** (performance) — all-ones gives the clean answer `N`.

## Random / fuzz testing

`fuzz.py` (next to this file) generates random fear-level lists, computes the
true maximum number of groups with an **independent exhaustive oracle** (it
searches over every possible grouping — not the greedy rule), runs your solution
on each, and reports mismatches. `N` is kept small so the exhaustive search stays
cheap. It auto-tests the highest-numbered `attempt_<N>.py` next to it. Run from
the repo root:

```
python3 "problems/이코테/그리디-모험가-길드/fuzz.py"
```

Seeded, so reproducible. Bump the loop counts to widen coverage.

## Test history

- **2026-05-30:** Folder set up. All 12 hand-picked cases + 3 performance cases
  cross-verified three independent ways (exhaustive search vs. DP vs. greedy),
  plus 4,000 random small cases — all consistent. Not yet run against the user's
  solution (it was still being written: reads input and sorts, no grouping logic
  yet).
- **2026-05-30:** `attempt_1.py` **passes everything** — 14 / 14 hand-picked and
  640 / 640 fuzz (exact stdout match), with the `N=100,000` cases running in
  ~0.06–0.10 s (well under a typical 1–2 s judge limit). Solved over several
  iterations: an early version over-counted by counting invalid intermediate
  groups (~268 / 640 fuzz failures); a fix using front-of-list slicing + `pop(0)`
  was correct but `O(N²)` (~5 s at N=100,000); the final version walks the sorted
  list with an index pointer — correct *and* fast.
