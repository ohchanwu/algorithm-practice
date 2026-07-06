# 문자열 뒤집기 — Baekjoon Online Judge problem 1439 ("뒤집기")

> Source judge: Baekjoon Online Judge (the Korean competitive-programming judge,
> often shortened to "BOJ"). Problem number 1439.

## Method used

Greedy (그리디 / 탐욕법)

> Note for future sessions: this field records the technique for an
> already-solved problem. Never volunteer it as a hint while the user is still
> working on a problem — see the golden rules in `../../CLAUDE.md`.

## Problem statement (문제)

0과 1로만 이루어진 문자열 `S`가 주어진다. 이 문자열의 모든 문자를 같은
숫자(전부 `0` 또는 전부 `1`)로 만들려고 한다. 한 번의 행동으로 할 수 있는 것은,
연속된 부분 문자열을 하나 골라 그 안의 모든 숫자를 뒤집는 것이다 (`0`은 `1`로,
`1`은 `0`으로 바꾼다). 문자열 전체를 같은 숫자로 만들기 위해 필요한 행동의 최소
횟수를 출력하라.

예: `S = 0001100` 일 때, 가운데의 `11`만 뒤집으면 `0000000`이 되므로 1번이면
모두 같은 숫자가 된다.

## Input / output contract

- **Input:** one line — the string `S`.
- **Output:** one integer — the minimum number of moves.
- Your solution reads input with `input()`, so `input.txt` holds the string on
  its first line. Run a single case from inside this folder (use your latest
  `attempt_<N>.py`):
  `cd "problems/이코테/그리디-문자열-뒤집기" && python3 attempt_1.py < input.txt`

## Constraints

- `S` can be long (the real judge allows roughly 100,000 characters), so the
  solution must run in linear time. Say no more than this about *how* to solve it.

## Verification oracle (test input → expected output)

These expected values were computed by hand from the problem definition, so they
are trustworthy ground truth for checking a run. **Encourage the user to predict
the output themselves before peeking** — that is where the learning happens. Do
not explain *why* an expected value is what it is; that would leak the method.

| input        | expected | what it stresses                          |
|--------------|----------|-------------------------------------------|
| `0`          | `0`      | single char, already uniform              |
| `1`          | `0`      | single char, starts with 1                |
| `00000`      | `0`      | all same (0s), empty inner loop           |
| `11111`      | `0`      | all same (1s)                             |
| `010`        | `1`      | tiny, starts/ends with 0                  |
| `101`        | `1`      | tiny, starts/ends with 1                  |
| `0011`       | `1`      | two blocks                                |
| `1100`       | `1`      | two blocks, starts with 1                 |
| `0110`       | `1`      | symmetric                                 |
| `0001100`    | `1`      | the user's original example               |
| `11101100`   | `2`      | uneven block sizes                        |
| `100110001`  | `2`      | many blocks, starts with 1                |
| `010101`     | `3`      | fully alternating, even length            |
| `0101010`    | `3`      | fully alternating, odd length             |
| `1010101`    | `3`      | fully alternating, starts with 1          |

### Large / performance cases (generate, don't paste a huge literal)

Run these from inside this problem folder so `input.txt` lands here:

```
python3 -c "print('01'*50000)" > input.txt   # length 100000, expected 50000
python3 -c "print('0'*100000)" > input.txt     # all same,      expected 0
python3 -c "print('10'*50000)" > input.txt     # starts with 1, expected 50000
```

## Strongest bug-catchers for this problem

In rough order of how often they break a wrong solution:

1. **Single character** (`0`, `1`) — off-by-one / empty-loop bugs.
2. **Already-uniform string** (`00000`, `11111`) — should be `0` moves.
3. **Strings that start with `1`** (`1100`, `1010101`) — solutions that only
   account for one digit tend to fail here.
4. **Fully alternating** strings (`010101`, `1010101`) — maximum number of blocks.

## Random / fuzz testing

A reproducible fuzz harness lives next to this file: `fuzz.py`. It generates
random `0`/`1` strings of varied length and digit-ratio, computes the expected
answer with an **independent** reference function (written separately from the
solution), and diffs the two. It auto-tests the highest-numbered `attempt_<N>.py`
next to it. Run from the repo root:

```
python3 "problems/이코테/그리디-문자열-뒤집기/fuzz.py"
```

It is seeded, so results are reproducible. Bump the loop counts inside it to
widen coverage.

## Test history

- **2026-05-30:** Ran the 15 hand-picked cases + 3 performance cases above — all
  produced the expected output, and the 100,000-char inputs returned instantly.
  Then ran 2,405 random fuzz cases (`seed=42`) against the independent oracle —
  zero mismatches. No failing input was found. (This records what was tested; it
  is not a statement to the user about whether their code is "correct.")
- **2026-05-30:** `sol_1_260530.py` **passes everything** — 15 / 15 hand-picked,
  3 / 3 performance, and 2400 / 2400 fuzz (exact stdout match), with the
  100,000-char case in ~0.06 s. A first version raised `IndexError` on every
  input (loop reached `s[i+1]` past the end, and the in-loop counter additions
  were no-ops); the fixed version corrects both and is clean.
