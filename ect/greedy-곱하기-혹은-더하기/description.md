# 곱하기 혹은 더하기 — 이것이 취업을 위한 코딩 테스트다 (이코테)

> Source: the book 이것이 취업을 위한 코딩 테스트다 (이코테), greedy chapter.
> Not a numbered Baekjoon problem.

## Method used

Greedy (그리디 / 탐욕법)

> Note for future sessions: this field records the technique for an
> already-chosen problem. Never volunteer it as a hint while the user is still
> working — see the golden rules in `../../CLAUDE.md`.

## Problem statement (문제)

각 자리가 숫자(`0`부터 `9`)로만 이루어진 문자열 `S`가 주어진다. 이 문자열의
왼쪽부터 오른쪽으로 숫자를 하나씩 보면서, 지금까지의 결과와 다음 숫자 사이에
`×` 또는 `+` 연산자 중 하나를 넣어 계산한다. 단, **일반적인 곱셈 우선순위는
무시하고 무조건 왼쪽에서 오른쪽 순서대로** 계산한다. 이렇게 만들 수 있는 가장
큰 수를 출력하라.

예: `S = "02984"` 이면 `((((0 + 2) × 9) × 8) × 4) = 576` 이 가장 크다. 다른 예로
`S = "567"` 이면 `((5 × 6) × 7) = 210` 이다.

## Input / output contract

- **Input:** one line — the digit string `S`.
- **Output:** one integer — the maximum value obtainable.
- Your solution reads the string with `input()` (e.g. `s = input()`).
  Run a single case from inside this folder (use your latest `attempt_<N>.py`):
  `cd "problems/이코테/그리디-곱하기-혹은-더하기" && python3 attempt_1.py < input.txt`

## Constraints

- `1 ≤ len(S) ≤ 20`.
- every character of `S` is a digit `0`–`9`.

## Verification oracle (test input → expected output)

Expected values were computed two independent ways — the true maximum by brute
force over **every** `+`/`×` choice (evaluated left-to-right), and the greedy
rule — and they agree. See `fuzz.py`. **Encourage the user to predict the answer
themselves before peeking**, and don't explain *why* a value is what it is.

| input `S` | expected | what it stresses                                       |
|-----------|----------|--------------------------------------------------------|
| `0`       | `0`      | single digit                                          |
| `1`       | `1`      | single digit                                          |
| `9`       | `9`      | single digit                                          |
| `00`      | `0`      | zeros only                                            |
| `10`      | `1`      | trailing 0 → must add, not multiply                  |
| `11`      | `2`      | ones only → adding beats multiplying                 |
| `19`      | `10`     | running total is 1 → must ADD even though 9 > 1       |
| `91`      | `10`     | next digit is 1 → must add                           |
| `99`      | `81`     | both > 1 → multiply                                  |
| `29`      | `18`     | both > 1 → multiply                                  |
| `111`     | `3`      | all ones → add all the way                           |
| `129`     | `27`     | leading 1 forces an add before the big multiply      |
| `234`     | `24`     | all > 1 → multiply chain                             |
| `1234`    | `36`     | leading 1 → add once, then multiply                 |
| `319`     | `36`     | the middle 1 forces an add                          |
| `2904`    | `72`     | a 0 in the middle → add at that step                |
| `567`     | `210`    | the book's second example                           |
| `02984`   | `576`    | the book's main example (leading 0)                 |
| `10203`   | `9`      | several 0s scattered                                |
| `991`     | `82`     | trailing 1 → add at the end                         |

### Large / performance cases

Run these from inside this problem folder so `input.txt` lands here:

```
python3 -c "print('9'*20)" > input.txt   # all nines → 9**20 = 12157665459056928801
python3 -c "print('2'*20)" > input.txt    # all twos  → 2**20 = 1048576
python3 -c "print('1'*20)" > input.txt    # all ones  → 20 (add every time)
```

## Strongest bug-catchers for this problem

In rough order of how often they break a wrong solution:

1. **Running total of 0 or 1** (`19`, `129`, `1234`) — the decision depends on
   *both* the running total and the next digit. A solution that only checks the
   next digit multiplies `1 × 9 = 9` instead of adding `1 + 9 = 10`. This is the
   single most common mistake.
2. **A 0 or 1 in the middle/end** (`2904`, `10203`, `991`) — must add at that
   step, not multiply.
3. **Single digit** — output the digit itself.
4. **Leading 0** (`02984`) — the string can start with 0.
5. **Large length** (performance) — 20 nines should give `9**20`, a big integer
   (Python handles big ints natively, so no overflow concern here).

## Random / fuzz testing

`fuzz.py` (next to this file) generates random digit strings (biased to include
plenty of 0s and 1s), computes the true maximum with an **independent brute-force
oracle** over every `+`/`×` choice (not the greedy rule), runs your solution, and
reports mismatches. It auto-tests the highest-numbered `attempt_<N>.py` next to
it. Lengths are kept small so the brute force stays cheap. Run from the repo root:

```
python3 "problems/이코테/그리디-곱하기-혹은-더하기/fuzz.py"
```

Seeded, so reproducible. Bump the loop counts to widen coverage.

## Test history

- **2026-05-30:** Folder created. All 20 hand-picked cases + 3 performance cases
  cross-verified two independent ways (brute force over all operator choices vs.
  the greedy rule) — all consistent. Not yet run against a real solution.
