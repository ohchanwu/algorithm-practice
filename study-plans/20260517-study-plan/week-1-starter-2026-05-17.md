# Getting Started — Week 0 (Python Ramp) + Week 1 (Chapter 3 그리디)

**Date**: 2026-05-17
**Revised**: 2026-05-21 — practice platform changed from Baekjoon to CodeUp + Programmers (see Revision note below)
**Companion**: [study-plan-design-2026-05-17.md](study-plan-design-2026-05-17.md)

Hand-holding for your first ~11 working days. You're brand new to Python (but know frontend JS and backend Go), so Week 0 is a focused Python ramp before touching algorithms. Week 1 is your first real 이코테 chapter (Ch. 3 — 그리디).

---

## Revision note (2026-05-21)

Baekjoon Online Judge shut down on 2026-04-28. This doc previously used Baekjoon for practice problems. It now uses:

- **CodeUp** ([codeup.kr](https://codeup.kr/)) for Week 0 — the "기초 100제" set is ideal for drilling Python syntax.
- **프로그래머스 (Programmers)** ([programmers.co.kr](https://programmers.co.kr/)) from Week 1 — algorithm practice, and the real Kakao/Naver/LINE test environment.

---

## Why Week 0 (and not "4hr/day in Week 1")

Your instinct that ramp-up costs something is right. The structure to avoid: learning a new language and new algorithms simultaneously — every stuck problem becomes "is this a 그리디 issue or a Python issue?" and you can't tell what to fix.

With JS + Go in hand, Python syntax is small and familiar. The week is mostly spent on the _coding-test-specific_ idioms that aren't in standard Python tutorials but you need from Day 1 of algorithm work: `collections.deque`, `heapq`, `bisect`, `itertools`, `sys.setrecursionlimit`.

6 days × 3 hr = 18 hr is enough.

---

## Week 0 — Python Ramp (6 days × 3 hr = 18 hr)

**Goal by Sunday**: solve any CodeUp 기초 100제 problem in Python without looking up syntax; know which library to reach for (queue, heap, binary search, combinations) without thinking.

**Practice platform**: CodeUp ([codeup.kr](https://codeup.kr/)). Find the **"기초 100제"** workbook — ~100 short problems organized in sections (출력 → 입력 → 산술/비교/논리/비트 연산 → 조건문 → 반복문 → 1·2차원 배열 → 문자열 → 함수). CodeUp is a stdin/stdout judge: you read input and print output. As a JS/Go dev you'll fly through the early sections — the point is Python-syntax repetition, not difficulty.

### Day 1 (Mon) — Syntax fundamentals

- **Warm-up (10 min)**: create your CodeUp account; skim 이코테 Part 4 table of contents
- **Block 1 (80 min)**: Read 이코테 Part 4 (Python syntax appendix). For someone with JS/Go, most is review — focus on what's _different_: indentation as syntax (no braces), no `let`/`const` (just `=`), `True`/`False` capitalized, `None` not `null`, tuple vs list (tuples immutable), `for i in range(n)` not C-style, no `i++` (use `i += 1`).
- **Break (15 min)**
- **Block 2 (70 min)**: Skim [점프 투 파이썬](https://wikidocs.net/1) chapters 02 (자료형) and 03 (제어문). Free Korean Python primer — fast skim for you. If time remains, start CodeUp 기초 100제 from the 출력 section.
- **Log (5 min)**: 3 lines — what was new, what was familiar, what to revisit

### Day 2 (Tue) — Lists, dicts, sets, comprehensions, slicing

- **Warm-up (10 min)**: write a `for` loop that prints squares 1-10 (lock in `range` + `print` syntax)
- **Block 1 (80 min)**: Lists deeply. `append`, `pop`, `sort(key=lambda x: ...)`, `reverse`, slicing. Important slicing tricks: `arr[::-1]` (reverse), `arr[i:j]` (subarray), `arr[::2]` (every other), `arr[:k]` (first k). List comprehensions: `[x*2 for x in arr]`, `[x for x in arr if x > 0]`, `[[0]*n for _ in range(m)]` (2D grid init — important, the obvious `[[0]*n]*m` is a trap).
- **Break (15 min)**
- **Block 2 (70 min)**: Dict and set operations + comprehensions. String methods: `split`, `join`, `replace`, `strip`, `isdigit`, f-strings (`f"x={x}"`). Direction gotcha: `'sep'.join([list])` reads backwards from JS/Go.
- **Log (5 min)**

### Day 3 (Wed) — I/O patterns + collections

- **Warm-up (10 min)**: write a function that sums even numbers in a list, using a comprehension and `sum()`
- **Block 1 (80 min)**: I/O patterns — these get practiced directly on CodeUp, since CodeUp is a stdin/stdout judge:
  - `input()` vs `sys.stdin.readline().rstrip()` — the latter is 2-5x faster, **required** for problems with tight time limits
  - Single-line: `n = int(input())`, `a, b = map(int, input().split())`, `arr = list(map(int, input().split()))`
  - Multi-line: `arr = [list(map(int, input().split())) for _ in range(n)]`
  - 2D grid: same pattern
  - `sys.setrecursionlimit(10**6)` — needed for any DFS deeper than ~1000 (Python default is 1000)
- **Break (15 min)**
- **Block 2 (70 min)**: `collections` library:
  - `collections.deque` — FIFO queue. `appendleft` / `popleft` are O(1); list's `insert(0, ...)` is O(n). Use deque for ALL BFS.
  - `collections.Counter` — count occurrences in a sequence; `Counter('aabbc')` → `{'a': 2, 'b': 2, 'c': 1}`
  - `collections.defaultdict(list)` — dict with default factory; no more `if key not in d: d[key] = []`
- **Log (5 min)**

### Day 4 (Thu) — heapq, bisect, itertools

- **Warm-up (10 min)**: print first 5 squares using a generator expression
- **Block 1 (80 min)**:
  - `heapq` (priority queue). Min-heap by default. `heapq.heappush(h, x)`, `heapq.heappop(h)`, `heapq.heapify(arr)` (in-place). For max-heap: push `-x`, pop and negate. Used in 다익스트라, "find K-th smallest," etc.
  - `bisect` (binary search on sorted arrays). `bisect_left(arr, x)`, `bisect_right(arr, x)`, `insort(arr, x)` (insert keeping sorted). Used when you'd otherwise write a binary search by hand.
- **Break (15 min)**
- **Block 2 (70 min)**: `itertools`:
  - `combinations(iterable, r)` — all r-subsets, order doesn't matter
  - `permutations(iterable, r)` — all r-arrangements, order matters
  - `product(iterable, repeat=n)` — cartesian product / nested loop replacement
  - Useful for brute-force / 완전탐색 problems where you'd otherwise write nested loops
  - (These won't appear in CodeUp 기초 100제 — practice them with the snippets at the end of this doc.)
- **Log (5 min)**

### Day 5 (Fri) — Practice: work through CodeUp 기초 100제

- **Warm-up (10 min)**: review yesterday's notes on heapq usage
- **Block 1 + Block 2 (150 min, with break)**: Work through the CodeUp 기초 100제 workbook in order — 출력, 입력, 연산, 조건문, 반복문, and into the 배열 sections. You'll move fast through the early ones; that's expected. The goal is Python-syntax fluency, not problem difficulty.
- **Log (5 min)**

If any single problem takes > 30 min, you're missing a Python piece — go back to Days 1-4 and re-read that section. Don't push through.

### Day 6 (Sat) — Finish 기초 100제 + preview Programmers

- **Warm-up (10 min)**: from memory, write the `import` + `sys.stdin.readline` setup snippet
- **Block 1 (80 min)**: Finish the remaining CodeUp 기초 100제 sections (배열, 문자열, 함수). Finishing all 100 is nice but not required — if Python syntax feels automatic, you've hit the goal.
- **Break (15 min)**
- **Block 2 (70 min)**: **Preview Programmers.** Go to the [코딩테스트 입문](https://school.programmers.co.kr/learn/challenges/beginner) section (Programmers' beginner test-prep track) and solve 3-4 problems there. The point isn't difficulty — it's meeting the format: Programmers gives you a `solution()` function to fill in and you `return` the answer (no input parsing, no printing). This is different from CodeUp/Baekjoon, so meet it now, before Week 1. Then save your reusable snippets (see end of this doc) to `algorithm-study/snippets.md`.
- **Log (5 min) + Week 0 retro (15 min)**: scan the week; note what's still shaky; commit to Week 1 starting Monday.

### Day 7 (Sun) — Rest

No algorithm work. Recharge.

---

## Week 1 — Chapter 3 그리디 (6 days × 3 hr = 18 hr)

You're now in your first real chapter cycle. Once you get the rhythm, Chapters 4-10 follow the exact same shape (Mon: theory, Tue-Wed: guided, Thu-Fri: drill, Sat: consolidate + retro, Sun: rest).

**Format heads-up**: from here on you practice on **Programmers**, which uses the `solution()` function format (you met it on Week 0 Day 6) — not the stdin/stdout style of CodeUp. The in-book 이코테 examples are written stdin/stdout style; just translate the logic into a `solution()` function when you move a problem onto Programmers.

**Resources for this week**:

- 이코테 Chapter 3 (그리디 알고리즘)
- 동빈나 YouTube — "그리디 알고리즘" video (from the [이코테 2021 playlist](https://www.youtube.com/playlist?list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC))
- 프로그래머스 — [알고리즘 고득점 Kit](https://school.programmers.co.kr/learn/challenges?tab=algorithm_practice_kit) → **탐욕법(Greedy)** section, plus Lv 1 practice problems. (The Kit is a tab on the practice page — _not_ the "모든 문제" tab, which is contest collections.)

### Day 1 (Mon) — Theory

- **Warm-up (10 min)**: re-solve a CodeUp problem from Week 0 you found tricky, from memory
- **Block 1 (80 min)**: Read 이코테 Chapter 3 in full. Sections: introduction, 거스름돈, 큰 수의 법칙, 숫자 카드 게임, 1이 될 때까지.
- **Break (15 min)**
- **Block 2 (70 min)**: Watch the 동빈나 그리디 video. Take notes as you watch. Pause to re-read book examples if anything is unclear.
- **Log (5 min)**: what clicked, what didn't, where the 그리디 intuition is unclear

### Day 2 (Tue) — Theory consolidation + first guided

- **Warm-up (10 min)**: explain in your own words why 거스름돈 works with greedy (1-2 sentences). If you can't, re-read book section.
- **Block 1 (80 min)**: Work 거스름돈 and 큰 수의 법칙 in-book examples. Try yourself first (15-20 min each), THEN read author solution. Re-implement from scratch without looking.
- **Break (15 min)**
- **Block 2 (70 min)**: Work 숫자 카드 게임 and 1이 될 때까지 the same way.
- **Log (5 min)**

### Day 3 (Wed) — Guided practice

- **Warm-up (10 min)**: re-solve any one of yesterday's 4 problems from memory
- **Block 1 + Block 2 (150 min total work, with break)**: Work the rest of in-book 예제 problems in Chapter 3 (it has a handful at the end). Same pattern: attempt → read solution → re-implement.
- **Log (5 min)**

### Day 4 (Thu) — Drill: in-book 기출

- **Warm-up (10 min)**: re-solve yesterday's hardest from memory
- **Block 1 + Block 2 (150 min)**: Solve in-book 기출 문제 unsupervised. **Apply stuck-handling rules**: 30-45 min attempt → hint (e.g., "this is a sorting-then-greedy pattern") → another 20 min → full solution → re-implement next day. Don't peek early.
- **Log (5 min)**

### Day 5 (Fri) — Drill: 프로그래머스

- **Warm-up (10 min)**: re-solve yesterday's hardest
- **Block 1 + Block 2 (150 min)**: On Programmers, solve problems from the **고득점 Kit → 탐욕법(Greedy)** section. Suggested order (easier → harder):
  - 체육복 (Lv 1)
  - 큰 수 만들기 (Lv 2)
  - 구명보트 (Lv 2)
  - 조이스틱 (Lv 2)
  - 단속카메라 (Lv 3) — stretch goal
  - Remember: write a `solution()` function and `return` the answer; no input parsing.
- **Log (5 min)**

### Day 6 (Sat) — Consolidate + weekly retro

- **Warm-up (10 min)**: skim the week's log
- **Block 1 (80 min)**: re-solve the 2-3 hardest problems from the week from memory, without looking at notes
- **Break (15 min)**
- **Block 2 (70 min)**: take "pattern notes" — what _makes_ a problem 그리디? What's the proof obligation (greedy choice + optimal substructure)? List 2-3 heuristics you noticed. Save to `algorithm-study/patterns.md`.
- **Weekly retro (15 min)**: append to log.md as "## Week 1 retro" — weak topics, strong topics, plan for Week 2 (Chapter 4: 구현).
- **Log (5 min)**

### Day 7 (Sun) — Rest

---

## After Week 1

Week 2 onward: same chapter cycle, substitute the next 이코테 chapter and the matching 프로그래머스 고득점 Kit section:

| Week | 이코테 chapter | Topic                                                      | 고득점 Kit section           |
| ---- | -------------- | ---------------------------------------------------------- | ---------------------------- |
| 2    | Ch. 4          | 구현 (시뮬레이션과 완전 탐색)                              | 완전탐색                     |
| 3    | Ch. 5          | DFS/BFS                                                    | 깊이/너비 우선 탐색(DFS/BFS) |
| 4    | Ch. 6          | 정렬                                                       | 정렬                         |
| 5    | Ch. 7          | 이진 탐색                                                  | 이분탐색                     |
| 6    | Ch. 8          | 동적 계획법 (DP) — **likely bleeds into Week 7; expected** | 동적계획법(DP)               |
| 7-8  | Ch. 9          | 최단 경로 (다익스트라, 플로이드)                           | 그래프                       |
| 8-9  | Ch. 10         | 그래프 이론 (MST, 위상정렬, 서로소 집합)                   | 그래프                       |

When you finish Chapter 10 (~Week 8-9), Phase 1 is done. Open the [study plan](study-plan-design-2026-05-17.md) Phase 2 section and resolve the open items there (99클럽 cohort timing, 코드트리 university check, Samsung emphasis).

---

## Quick reference: snippets you'll reuse forever

Save these to `algorithm-study/snippets.md` (or muscle-memorize them).

**Programmers format** — from Week 1 on, you fill in a function and return the answer. No input parsing, no printing:

```python
def solution(arr):
    answer = 0
    # compute the answer using arr
    return answer
```

**Fast input setup** — for CodeUp (Week 0) and Samsung-style stdin/stdout judges. NOT needed on Programmers:

```python
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
```

**BFS template**:

```python
from collections import deque

def bfs(start):
    visited = [False] * (n + 1)
    queue = deque([start])
    visited[start] = True
    while queue:
        node = queue.popleft()
        # process node
        for nxt in graph[node]:
            if not visited[nxt]:
                visited[nxt] = True
                queue.append(nxt)
```

**DFS template (recursive)**:

```python
import sys
sys.setrecursionlimit(10**6)

def dfs(node, visited):
    visited[node] = True
    # process node
    for nxt in graph[node]:
        if not visited[nxt]:
            dfs(nxt, visited)
```

**Heap usage**:

```python
import heapq

h = []
heapq.heappush(h, value)
smallest = heapq.heappop(h)
# for max-heap: push -value, pop and negate
```

**Combinations / permutations / product**:

```python
from itertools import combinations, permutations, product

for combo in combinations([1, 2, 3, 4], 2):  # all 2-element subsets
    print(combo)

for perm in permutations([1, 2, 3], 2):  # all 2-element arrangements
    print(perm)

for x, y in product(range(3), range(3)):  # 3x3 grid coordinates
    print(x, y)
```
