# Algorithm Study Plan — Design

**Date**: 2026-05-17
**Revised**: 2026-05-21 — practice platform changed from Baekjoon to CodeUp + Programmers (see Revision note below)
**For**: Korean tech job coding tests
**User profile**: 비전공자 (non-CS major), beginner, Python, 3 hr/day × 6 days/week, currently pre-SSAFY 16기 (interim period — applying to jobs and building projects in parallel while waiting on 16기 result; fallback is 17기 in October 2026)
**Companion document**: [marketplace-research-2026-05-17.md](marketplace-research-2026-05-17.md) — full landscape of resources considered (note: predates the Baekjoon shutdown).

---

## Revision note (2026-05-21)

Baekjoon Online Judge (백준) — originally the plan's primary practice platform — **shut down on 2026-04-28** after 16 years. solved.ac, which depended entirely on Baekjoon, can no longer function as a progression system. The plan now uses:

- **CodeUp** for Week 0 (Python syntax ramp)
- **프로그래머스 (Programmers)** from Week 1 onward (algorithm drill — and the real Kakao/Naver/LINE test environment)

One judge at a time, sequential — never two in parallel. If Programmers ever feels thin, Codetree is the next resource (Phase 2-3), not a parallel addition.

---

## Goal

Pass entry-level Korean tech job coding tests at companies including Samsung (역량테스트), Naver, Kakao Blind, LINE, Coupang, Toss, NCSOFT, Krafton, and smaller startups.

**Concrete success marker**: by end of Phase 2 (~week 13), consistently solve **프로그래머스 Lv 2** problems unaided and make steady progress on **Lv 3**. Kakao Blind problems run mostly Lv 2-3, so that level clears most entry-level 신입 코테.

## Constraints and ground rules

- **3 hours/day study, 6 days/week** (Sunday rest). Total: 18 hr/week.
- **Python** as the primary language. JavaScript dropped — see marketplace research for reasoning (missing built-ins, weak tutorial ecosystem, narrower company coverage).
- **One practice platform at a time.** Sequential, never parallel — running two judges at once is needless complexity.
- **Sequential phases.** Each phase has ONE main focus. New tracks (카카오 기출, 99클럽, second book) are not added until the prior phase is complete.
- **Concurrent life context**: project work and job applications run in parallel. Algorithm study is one of three things competing for daily time, not the only thing.

---

## Phase Structure (Sequential)

### Week 0 — Python ramp (before Phase 1)

**Goal**: fluent Python syntax; comfortable writing small programs without looking things up.

**Resources**:

- 이코테 Part 4 (Python syntax appendix) + [점프 투 파이썬](https://wikidocs.net/1) (free) — for learning
- **CodeUp** ([codeup.kr](https://codeup.kr/)) — the "기초 100제" beginner problem set, for drilling Python syntax into muscle memory. CodeUp is a stdin/stdout judge, so it also builds input-parsing reflexes (the format Samsung 역량테스트 uses).

See [week-1-starter-2026-05-17.md](week-1-starter-2026-05-17.md) for the day-by-day breakdown.

### Phase 1 — Foundations (~weeks 1-8)

**Goal**: complete 이코테 (이것이 취업을 위한 코딩 테스트다) cover-to-cover with retention; comfortable solving 프로그래머스 Lv 1-2 problems on the topics covered.

**Resources**:

- 이코테 (나동빈) — book, ~30,000 KRW
- 동빈나 YouTube companion playlist (free)
- **프로그래머스 (Programmers)** ([programmers.co.kr](https://programmers.co.kr/), free) — drill each chapter's topic using the matching section in the [알고리즘 고득점 Kit](https://school.programmers.co.kr/learn/challenges?tab=algorithm_practice_kit), plus Lv 0-2 practice problems. The Kit is a **tab** on the practice page — not the "모든 문제" tab, which shows contest/exam collections instead.

**Cycle**: 1 이코테 chapter per week, 8 weeks for the 8 core algorithm chapters in Part 2 (그리디, 구현, DFS/BFS, 정렬, 이진탐색, DP, 최단경로, 그래프이론).

**이코테 chapter → 프로그래머스 고득점 Kit mapping** (what to drill each week):

| 이코테 chapter    | 프로그래머스 고득점 Kit section |
| ----------------- | ------------------------------- |
| Ch. 3 그리디      | 탐욕법(Greedy)                  |
| Ch. 4 구현        | 완전탐색                        |
| Ch. 5 DFS/BFS     | 깊이/너비 우선 탐색(DFS/BFS)    |
| Ch. 6 정렬        | 정렬                            |
| Ch. 7 이진탐색    | 이분탐색                        |
| Ch. 8 DP          | 동적계획법(Dynamic Programming) |
| Ch. 9 최단경로    | 그래프                          |
| Ch. 10 그래프이론 | 그래프                          |

**Explicitly NOT in Phase 1**: 카카오 기출 problem sets specifically, 항해99 99클럽, second book, 코드트리, LeetCode. Adding these now would dilute focus.

### Phase 2 — Volume + accountability (~weeks 9-13)

**Goal**: build problem-solving volume through the Lv 2 → Lv 3 transition; develop coding-test format fluency.

**Resources**:

- **프로그래머스 Lv 2-3** — primary daily problem source
- **프로그래머스 카카오 기출** — weekly 2hr mock coding test (Kakao runs ON 프로그래머스, so the environment matches the real test)
- **항해99 99클럽 코딩테스트 스터디** — enroll in the next available 5-week cohort that aligns with this phase (~30,000 KRW; daily 인증, level-matched problems, peer accountability)

**Cycle**: daily 프로그래머스 Lv 2-3 work + one weekly 2hr 카카오 기출 mock session.

### Phase 3 — Real coding test prep (week 14+)

**Goal**: pass real company coding tests.

**Resources**:

- **Second book** for breadth: 코딩테스트 합격자 되기: 파이썬 편 (broad target list; built around 프로그래머스 problems, so well-aligned post-Baekjoon) OR 파이썬 알고리즘 인터뷰 (박상길 — denser; specifically Kakao/Naver/LINE)
- **SWEA (SW Expert Academy)** — Samsung's own platform; practice Samsung 역량테스트-style problems there if Samsung is a target
- Weekly mock under real time pressure
- Real applications and test attempts; iterate based on what each company's test actually requires

Phase 3 is intentionally open-ended — once you're past Phase 2, the right move depends on which companies have upcoming hiring cycles and what their test styles emphasize.

---

## Daily Session (3 hours)

| Block   | Time   | Content                                                                                                              |
| ------- | ------ | -------------------------------------------------------------------------------------------------------------------- |
| Warm-up | 10 min | Re-solve yesterday's hardest problem from scratch (spaced repetition — kills the "I solved it once and forgot" trap) |
| Block 1 | 80 min | Main task per chapter-cycle day (theory / guided / drill — see chapter cycle below)                                  |
| Break   | 15 min | Walk, eat, anything non-screen                                                                                       |
| Block 2 | 70 min | Continue main task or shift to related lighter work (e.g., theory in Block 1 → in-book 예제 in Block 2)              |
| Log     | 5 min  | 3 lines in log.md                                                                                                    |

Total: 180 min.

The mid-session break is non-negotiable for 3hr sessions. Focused cognitive work degrades sharply past ~90 min without rest.

## Chapter Cycle (Phase 1 — 6 days per 이코테 chapter)

| Day | Focus                 | Activities                                                                                           |
| --- | --------------------- | ---------------------------------------------------------------------------------------------------- |
| Mon | Theory                | Read full chapter + watch matching 동빈나 video                                                      |
| Tue | Theory + first guided | Re-read tricky parts + work 1-2 in-book 예제 carefully                                               |
| Wed | Guided practice       | Work remaining 예제 (2-3); read author solutions; internalize the canonical pattern                  |
| Thu | Drill                 | In-book 기출 problems (5-8, unsupervised — you solve, then check)                                    |
| Fri | Drill + 프로그래머스  | Finish in-book 기출 + 5-8 프로그래머스 problems on the same topic (고득점 Kit section + Lv 1-2)      |
| Sat | Consolidate + retro   | Re-solve 2-3 hardest problems from the week without looking; take pattern notes; 15-min weekly retro |
| Sun | Rest                  | No algorithm work                                                                                    |

(Days are anchored to Mon-Sun for clarity. Shift if your schedule needs a different rest day, but keep the structure.)

Hard chapters (especially DP and 최단경로) may legitimately bleed into the next week. Treat this as expected, not failure — just push the next chapter's start by a few days.

## Weekly rhythm

- 6 study days + 1 rest day (rest is required, not optional)
- Saturday: consolidate + 15-min weekly retro (list weak topics, decide what to re-solve next week)
- Sunday: full rest from algorithms (project work and job apps still OK)

## Stuck-handling rules

The two failure modes to avoid:

1. **Staring at one problem for 3 hours** — you learn nothing and lose motivation.
2. **Looking up solutions in 5 minutes** — you never develop problem-solving skill.

Time caps to split the difference:

- **New-topic problem (Phase 1 chapter currently in progress)**: 30-45 min attempt → read a hint (e.g., "this is BFS") → another 20 min → read full solution → re-implement from memory next day
- **Practice on already-learned topic**: 45-90 min attempt → look at solution
- **Re-solving an old problem (warm-up / consolidate)**: 15-30 min cap

## Tracking

Single file: `algorithm-study/log.md`. Daily 3-line append:

```markdown
## 2026-05-18 (Mon) — Ch. 3 그리디 (Day 1/6 — theory)

- Read sections 3.1-3.3, watched 동빈나 video #4
- Got 거스름돈 example without help; 큰 수의 법칙 needed hint
- Tomorrow: in-book 예제 1-2
```

Weekly retro entry (Saturday):

```markdown
## Week 3 retro (2026-06-08)

- Weak: 백트래킹 (kept missing base case)
- Strong: 그리디 (canonical pattern clicked)
- Next week plan: re-solve 2 백트래킹 problems from this week before starting Ch. 4
```

No spreadsheets, no apps. The point of logging is to make weak topics visible at retro time.

---

## Phase Transition Criteria

- **Phase 1 → 2**: All 8 이코테 chapters (Part 2) complete. Can solve 프로그래머스 Lv 1-2 problems on covered topics without significant help.
- **Phase 2 → 3**: Can solve ~half of a 카카오 기출 set (Lv 2) in 2 hours. Consistently clearing Lv 2, making progress on Lv 3.

If you hit a transition criterion early, advance early. If you're behind by 1-2 weeks, that's expected — don't compress quality to hit dates.

## Setup checklist (before Day 1)

- [ ] Buy 이코테 book (~30,000 KRW from 교보문고 / yes24 / aladin)
- [ ] Create accounts: [CodeUp](https://codeup.kr/) (Week 0 platform), [프로그래머스](https://programmers.co.kr/) (Week 1 onward)
- [ ] Install Python 3.11+ and a code editor (VS Code recommended) — your local setup is the main environment for learning; online judges are for submitting
- [ ] Bookmark the [동빈나 YouTube playlist](https://www.youtube.com/playlist?list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC)
- [ ] Create `algorithm-study/log.md` (start with a date heading)
- [ ] **You're new to Python** (confirmed; JS + Go background): execute **Week 0** from [week-1-starter-2026-05-17.md](week-1-starter-2026-05-17.md) before starting Chapter 3 — 6 days of CodeUp-based Python ramp. JS/Go background means syntax is fast; the coding-test-specific idioms (`collections.deque`, `heapq`, `bisect`, `itertools`) aren't skippable.

## Open items (resolve before or during Phase 2)

- **코드트리 university partnership** — if your school partners with [codetree.ai](https://www.codetree.ai/), access is free. Confirmed partners include HUFS, Pukyong, Hansung, Sungshin (as of 2025). Post-Baekjoon, Codetree is the natural _next_ structured resource if 프로그래머스 ever feels thin — so this check matters more now. **Action**: check university notices before starting Phase 2.
- **Samsung emphasis** — if Samsung 역량테스트 is a primary target, Phase 3 should weight SWEA practice heavily. **Action**: confirm target company priorities by end of Phase 2.
- **99클럽 cohort timing** — check [항해99](https://hanghae99.spartaclub.kr/99club-codingtest) near end of Phase 1 for upcoming cohort dates so Phase 2 aligns with a cohort start.

## Non-goals (explicitly out of scope)

- Reaching competitive-programming level (overkill for entry-level Korean tech jobs)
- Learning C++ or Java (Python is sufficient for the target company list)
- Completing all 40+ problems in 이코테 Part 3 (sample as time allows, don't force-finish)
- Codeforces / LeetCode hard / ICPC content
- US-style behavioral or whiteboard interview prep (defer until past the coding-test stage)

## Python performance notes

- **On 프로그래머스**: problems separate 정확성 (correctness) and 효율성 (efficiency) test cases. Passing 정확성 but failing 효율성 means your algorithm's time complexity is too high — that's an _algorithmic_ problem to fix, not a language one (use a set/dict for lookups, `deque` for queues, sorting instead of nested loops, etc.).
- **On stdin/stdout judges** (CodeUp in Week 0; Samsung 역량테스트 later): use `sys.stdin.readline` instead of `input()` for fast input. Plain `input()` is slow enough to cause time-limit failures on large inputs.
