# Korean Algorithm Coding-Test Prep Marketplace Report

> **Revision note (2026-05-21)**: Baekjoon Online Judge shut down on 2026-04-28. The 백준 and solved.ac entries below are kept for historical context but are no longer actionable. The live plan now uses CodeUp (Week 0) and 프로그래머스 / Programmers (Phase 1+) — see [study-plan-design-2026-05-17.md](study-plan-design-2026-05-17.md).

**Date**: 2026-05-17
**Profile**: 비전공자 (non-CS major), beginner, Python, ~2 hrs/day, targeting Korean tech jobs (Samsung 역량테스트, Naver, Kakao Blind, LINE, Coupang, Toss, NCSOFT, Krafton)

---

## 1. Books

### 이것이 취업을 위한 코딩 테스트다 with 파이썬 (이코테, 나동빈)
- **What it is**: Korean-original, Python-first coding-test bible covering 8 core algorithm patterns with Samsung/Kakao/LINE 2016-2020 past problems ([교보문고](https://product.kyobobook.co.kr/detail/S000001810273)).
- **Cost**: ~30,000 KRW.
- **Best for**: True beginners and 비전공자. Includes a Python-syntax appendix.
- **Language**: Python is the first-class language; C++/Java mentioned briefly in lectures.
- **Time**: 6-10 weeks at 2 hrs/day.
- **Pros**: Author runs the free 동빈나 YouTube companion course; problems are mapped to actual Korean corporate tests; trendy and well-structured.
- **Cons**: Past-problem set ends ~2020; doesn't reflect 2023-2026 Kakao/Toss difficulty inflation; some sections (greedy/구현) feel light.
- **Gotchas**: Many readers finish 이코테 and still bomb actual Kakao tests because the book under-represents harder 구현/시뮬레이션 problems Samsung now favors ([velog 회사별 후기](https://velog.io/@soonyoung/%ED%9A%8C%EC%82%AC%EB%B3%84-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%8A%A4%ED%83%80%EC%9D%BC-%EB%B0%8F-%ED%9B%84%EA%B8%B0)).

### 파이썬 알고리즘 인터뷰 (박상길, "박상길책")
- **What it is**: 95 LeetCode-style problems with deep Python idioms; written by a former Kakao coding-test 출제위원 ([교보문고](https://product.kyobobook.co.kr/detail/S000001932748)).
- **Cost**: ~38,000 KRW.
- **Best for**: People who already know basic algorithms; Naver/Kakao/LINE specifically.
- **Language**: Python, with serious attention to Python internals (CPython behavior, time complexity).
- **Time**: 2-3 months for the full book; treat as "second book."
- **Pros**: Author was literally a Kakao 출제위원, so problem selection mirrors real Korean FAANG-tier tests; covers LeetCode problems so you can practice live; 부록 B includes a 2017 Kakao past test walkthrough.
- **Cons**: Hard for absolute beginners — frequently called too dense as a first book ([velog dion](https://velog.io/@dion/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%9D%B8%ED%84%B0%EB%B7%B0-%EB%A6%AC%EB%B7%B0)); ~1000 pages can become a "stalled bookshelf trophy."
- **Gotchas**: Best read after finishing 이코테 or after ~100 백준 silver problems.

### 코딩 테스트 합격자 되기: 파이썬 편 (박경록, 골든래빗)
- **What it is**: Newer (2024) Korean book built around 프로그래머스 problems, categorized by frequency from real corporate tests ([교보문고](https://product.kyobobook.co.kr/detail/S000210881884), [위키독스 미리보기](https://wikidocs.net/book/13314)).
- **Cost**: ~32,000 KRW.
- **Best for**: 비전공자 beginners — explicitly designed for "코테 처음 준비하는 분."
- **Language**: Python, with C++/JavaScript editions also available.
- **Time**: 1-2 months focused.
- **Pros**: Each chapter has 이론 → 몸 풀기 → 실전 모의 structure; explicit 빈출 ordering; author runs a Naver Cafe + 24-hr KakaoTalk room for Q&A ([dremdeveloper Inflearn](https://www.inflearn.com/users/777211/@dremdeveloper)); free companion lecture on Inflearn.
- **Cons**: Newer means fewer published reviews than 이코테; can feel "프로그래머스-only" if you're targeting Samsung's 백준-style 역량테스트.
- **Gotchas**: Check the GitHub for errata ([GitHub](https://github.com/dremdeveloper/codingtest_python)).

### Do it! 알고리즘 코딩 테스트: 파이썬 편 (김종관)
- **What it is**: 100 past-problem-style exercises covering algorithms for Naver/Kakao/Samsung/LINE ([교보문고](https://product.kyobobook.co.kr/detail/S000217333575)).
- **Cost**: ~30,000 KRW.
- **Best for**: Beginners who like a textbook-style, friendly tone.
- **Language**: Python (also Java/C++/JS editions).
- **Pros**: Approachable for true beginners; widely available in libraries.
- **Cons**: Substantially overlaps with 이코테 and 합격자 되기 — pick one of the three, not all.
- **Gotchas**: If you already own 이코테, skip this; you'll just re-read the same material.

### 알고리즘 문제 해결 전략 (종만북, 구종만)
- **What it is**: The legendary 2-volume PS textbook from Korea's ICPC/competitive-programming community.
- **Cost**: ~80,000 KRW for the set.
- **Best for**: Intermediate-to-advanced; people targeting ICPC, Samsung B형, or who want to think like a competitive programmer.
- **Language**: **C++** — Python is not a first-class citizen. Major blocker for your profile.
- **Pros**: Best problem-solving-process explanations in any Korean algorithm book.
- **Cons**: Wrong language, wrong difficulty for a 비전공자 beginner; published 2012, so problem judges (algospot) have decayed; massive overkill for the listed company set.
- **Gotchas**: People recommend this out of cargo-cult respect. For your profile, **do not buy**.

### Cracking the Coding Interview (Gayle McDowell)
- **What it is**: The de facto US/FAANG interview prep book.
- **Cost**: ~38,000 KRW Korean edition.
- **Best for**: People targeting US-style live-coding interviews.
- **Language**: Java-leaning, with some C++/Python.
- **Pros**: Good behavioral/whiteboarding mindset.
- **Cons**: Korean coding tests are **automated online judges** (백준/프로그래머스 style), not whiteboard interviews. ~70% of CtCI value doesn't apply.
- **Gotchas**: Useful only if you reach onsite interviews at Coupang/Toss/Google Korea later — not for passing the coding test itself.

### Elements of Programming Interviews in Python (Aziz et al.)
- **What it is**: 250+ harder interview problems with Python solutions.
- **Cost**: ~$40 USD.
- **Best for**: Senior-level interview prep; FAANG.
- **Pros**: Harder, more idiomatic than CtCI; great Python-specific solutions.
- **Cons**: English-only; problem style is US-FAANG, not Korean simulation/구현.
- **Gotchas**: Pure overkill for the target list. Skip unless aiming at Google/Meta later.

### 그림으로 배우는 알고리즘 / Grokking Algorithms
- **What it is**: Illustrated algorithm primer.
- **Cost**: ~18,000 KRW.
- **Best for**: Absolute beginners who've never seen a graph traversal explained.
- **Pros**: 400+ illustrations; readable in a weekend.
- **Cons**: Too shallow to pass any actual coding test.
- **Gotchas**: Week-1 confidence-builder only, then drop.

---

## 2. Online Problem Platforms

### 백준 Online Judge + solved.ac
- **What it is**: The dominant Korean OJ; solved.ac is its tier/CLASS overlay ([baekjoon](https://www.acmicpc.net/), [solved.ac CLASS](https://solved.ac/class)).
- **Cost**: Free (solved.ac Premium is optional, ~5,000 KRW/month).
- **Best for**: Everyone. Required for Samsung 역량테스트 prep specifically.
- **Language**: All major languages (Python 3, PyPy3 strongly supported).
- **Time investment**: Open-ended; CLASS 1-3 = 1 month, CLASS 4 = 2 months, CLASS 5 = 3+ months.
- **Pros**: 30,000+ problems; CLASS system curates the essential ones; solved.ac tier badges create motivation; "단계별로 풀어보기" is the gentlest on-ramp for true beginners.
- **Cons**: Python TLE problem — many problems require PyPy3; UI feels dated; no built-in lectures.
- **Gotchas**: For Python users, **always submit with PyPy3** when time-limited; many beginners blame their algorithm when it's really Python interpreter overhead.

### 프로그래머스
- **What it is**: Korea's #1 hiring-test platform; hosts the actual Kakao Blind, Toss NEXT, LINE, etc. ([programmers.co.kr](https://programmers.co.kr/)).
- **Cost**: Free for practice; SKILL CHECK & 데브매칭 are also free.
- **Best for**: Mandatory if you're targeting Kakao, LINE, NCSOFT, Krafton, or any company that uses 프로그래머스 as the test platform.
- **Language**: Python first-class; solution-function style (no stdin/stdout parsing).
- **Time investment**: 카카오 기출 (Lv 2-3) — ~2 months focused.
- **Pros**: Cleanest UI; categorized by company and level; SKILL CHECK gives a free certificate.
- **Cons**: Fewer total problems than 백준; harder to drill specific algorithm topics.
- **Gotchas**: 2025 Kakao removed per-testcase scoring and added internet-search restriction text — practice with the same constraints.

### SWEA (SW Expert Academy)
- **What it is**: Samsung's official problem platform.
- **Cost**: Free (Samsung-account login).
- **Best for**: Anyone targeting Samsung 역량테스트 (구현/시뮬레이션-heavy).
- **Language**: Python supported but historically buggy; C++/Java are first-class.
- **Pros**: Holds the actual Samsung 기출; 모의 SW 역량테스트 problems mirror the real test exactly.
- **Cons**: UI is outdated; the editor is painful; some problems require Samsung internal account quirks.
- **Gotchas**: Many people just mirror SWEA Samsung 기출 onto 백준 (workbook 1152) and solve there instead.

### 코드트리 (codetree.ai)
- **What it is**: IOI-medalist-built structured curriculum + judge specifically aimed at Korean corporate coding tests, esp. Samsung/Hyundai/Naver ([codetree](https://www.codetree.ai/)).
- **Cost**: Paid subscription (monthly), commonly quoted around **~49,000 KRW/month with 학생 인증**. **Free** if your university has a partnership ([HUFS notice](https://builder.hufs.ac.kr/user/boardList.action?command=view&page=1&boardId=129898051&boardSeq=161848186)).
- **Best for**: Beginners who need a guided path more than a problem firehose; Samsung 역량테스트 specifically.
- **Language**: Python, C++, Java — Python is first-class.
- **Time investment**: 3-6 months for full Novice → Intermediate.
- **Pros**: Genuinely the most pedagogically polished Korean platform; concept video → guided problem → harder problem → real-test problem in a single track; fast admin Q&A response.
- **Cons**: Subscription cost adds up; problem pool smaller than 백준.
- **Gotchas**: **Check if your university (or 비전공자 알고리즘 캠프) gives free access before paying** — Pukyong, Hansung, Sungshin, HUFS all have notices about free 학내 access.

### LeetCode
- **What it is**: The global problem platform; standard for FAANG prep.
- **Cost**: Free; Premium ~$35/month for company-tagged problems.
- **Best for**: Coupang, Google Korea, Meta Korea; also pairs with 박상길 책 which references LeetCode problem numbers directly.
- **Language**: Python first-class.
- **Pros**: Best problem-discussion ecosystem; cleaner Python performance than 백준; company-tagged filtering.
- **Cons**: Problem culture skews US-FAANG over Korean simulation; English UI; limited Samsung/Kakao-style 구현 problems.
- **Gotchas**: For pure Kakao/Samsung prep, LeetCode is supplementary, not core.

### Codeforces / AtCoder / CSES
- **What it is**: Competitive-programming contest platforms.
- **Cost**: Free.
- **Best for**: People aiming at the top 5%, or who want intellectual depth.
- **Language**: Python supported but slow; C++ strongly preferred.
- **Pros**: AtCoder Beginner Contest (ABC) problems are excellent for building algorithmic intuition; CSES is the cleanest curated problem set.
- **Cons**: Steep curve; English/Russian UI; almost no overlap with the Samsung 구현 style.
- **Gotchas**: Don't go here until you're solid at 백준 Gold.

### HackerRank / Codewars
- **What it is**: Western practice platforms.
- **Cost**: Free.
- **Cons**: Almost no Korean company uses these as a test platform; problem culture doesn't transfer.
- **Gotchas**: Not worth your time for this profile.

---

## 3. Video Courses / Paid Lectures

### 동빈나 YouTube — "이코테 2021 강의 몰아보기"
- **What it is**: Free companion lectures to 이코테 book, ~10 hours total ([YouTube playlist](https://www.youtube.com/playlist?list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC)).
- **Cost**: Free.
- **Best for**: Anyone using the 이코테 book; 비전공자.
- **Pros**: Author-taught; pairs 1:1 with the book; 1080p re-recorded; community is large.
- **Cons**: Recorded in 2021, so no 2024-2026 Kakao trends; some explanations are fast for true beginners.
- **Gotchas**: Use these alongside the book, not as a replacement.

### 바킹독의 실전 알고리즘 (encrypted.gg + YouTube)
- **What it is**: Free 6-year-curated algorithm lecture series by a top-tier KOI/ICPC competitor.
- **Cost**: Free.
- **Best for**: Slightly stronger learners willing to grind; covers up to Gold/Platinum-tier algorithms.
- **Language**: **C++ only.** Major issue for your profile.
- **Pros**: Highest-quality algorithm content in Korean; refined over 6 years of feedback; integrated with 백준 problems.
- **Cons**: C++ blocks Python-first learners.
- **Gotchas**: Watch for *concepts* only if you can mentally translate to Python; otherwise skip.

### 큰돌 "10주완성 C++ 코딩테스트" (Inflearn)
- **What it is**: Bestseller Inflearn course with 160 recommended problems.
- **Cost**: Typically ~88,000 KRW (frequent discounts).
- **Language**: **C++.**
- **Gotchas**: Don't buy unless you switch languages.

### 개발남노씨 "코딩테스트 ALL IN ONE" (Inflearn)
- **What it is**: Multi-language (Python/Java/C++/JS) coding-test course with visualized code execution.
- **Cost**: ~70,000-90,000 KRW (discount frequent).
- **Best for**: 비전공자 visual learners.
- **Language**: Python supported as first-class.
- **Pros**: Step-by-step code visualization, frequent 빈출 templates.
- **Gotchas**: Wait for Inflearn sales (~50% off) — never pay sticker.

### dremdeveloper "코딩테스트 합격자 되기" (Inflearn — currently FREE)
- **What it is**: Free Inflearn course paired with the 골든래빗 책.
- **Cost**: **Free** (currently marked "지금 무료" on Inflearn).
- **Best for**: Bridging the 합격자 되기 book to video form; 비전공자.
- **Pros**: Free; instructor has 10+ yrs dev experience.
- **Cons**: Newer instructor with less brand recognition.
- **Gotchas**: "지금 무료" can end; grab while available.

### "눈떠보니 코딩테스트 전날" (Inflearn)
- **What it is**: Compact crash-course for last-minute prep.
- **Cost**: Inexpensive.
- **Best for**: People with a test in <1 week.
- **Language**: Python + JavaScript.
- **Gotchas**: Crash-course only; not a primary resource.

### 패스트캠퍼스 "네카라쿠배 끝장내는 파이썬 코딩테스트 마스터"
- **What it is**: Premium long-form 초격차 패키지.
- **Cost**: Typically **300,000-700,000 KRW** depending on bundle.
- **Pros**: Includes 300 problems + mock exams + technical-interview module.
- **Cons**: Massively overpriced vs. free YouTube + book + 백준; reviews mixed; sunk-cost trap is real.
- **Gotchas**: For 99% of profiles, you can replicate the curriculum for <50,000 KRW. Skip unless you specifically need the "패키지" accountability structure.

### Princeton Algorithms (Coursera, Sedgewick & Wayne)
- **What it is**: The CS-101 algorithms gold-standard MOOC.
- **Cost**: Free to audit.
- **Language**: **Java.**
- **Pros**: Best lecture quality of any algorithm course, period.
- **Cons**: Java; theoretical bias doesn't help you pass a Samsung simulation problem next week.

---

## 4. Bootcamps / Structured Paid Programs

### 항해99 — 99클럽 코딩테스트 스터디
- **What it is**: 5-week structured 코테 study cohort with daily check-ins, level-matched problems, and weekly live lectures ([99클럽](https://hanghae99.spartaclub.kr/99club-codingtest)).
- **Cost**: **~30,000 KRW** (often refundable on completion).
- **Best for**: People who can't sustain solo daily practice; level-matched (Beginner/Middler/Challenger maps to 백준 Bronze/Silver/Gold).
- **Language**: Language-agnostic (Python welcome).
- **Time**: ~35 days, ~1-2 hrs/day.
- **Pros**: Cheapest accountability hack on the market; daily 인증 forces consistency; consistently rated "10만원 이상 가치" for the 3만원 price.
- **Cons**: Quality of lectures uneven across cohorts; assumes you already pick your own resources.
- **Gotchas**: Best used as a **discipline scaffold** alongside 이코테 + 백준, not a replacement.

### 제로베이스 코딩테스트 합격 온라인 완주반
- **What it is**: 51-day coding-test 합격 program with LG dev mentors.
- **Cost**: Often quoted with "후불제 / 연봉 3500 미만 시 0원" structure.
- **Pros**: Real human coaching; income-share-style payment reduces upfront risk.
- **Gotchas**: Read the contract carefully; the 후불제 terms vary.

### 스파르타코딩클럽 / 내일배움캠프
- **What it is**: KDT-funded bootcamps.
- **Cost**: KDT — free + ~1M KRW 훈련장려금/month.
- **Best for**: Full career-changers, not coding-test cramming specifically.
- **Gotchas**: Wrong tool for 2 hrs/day; only relevant if pivoting careers entirely.

### 우아한테크코스 (우테코) 프리코스
- **What it is**: Free 5-week pre-course gate for 우테코.
- **Cost**: Free.
- **Best for**: People applying to 우테코 specifically; assumes Java.
- **Gotchas**: Not a generic 코테 prep; only do it if you're applying to 우테코.

---

## 5. Mock Test / Practice Exam Services

### 프로그래머스 SKILL CHECK & 데브매칭
- **What it is**: Free skill assessment + recruiter-matching service.
- **Cost**: Free.
- **Pros**: Real test-environment feel; certificate; can lead directly to interview offers.

### 코드트리 모의고사
- **What it is**: Codetree-curated full mock tests mimicking Samsung/Naver/Hyundai formats.
- **Cost**: Included in subscription.
- **Pros**: Highest-fidelity Samsung 역량테스트 simulator on the market.

### 카카오 코드 페스티벌 / Kakao mock (annual)
- **What it is**: Annual practice round before Kakao 블라인드.
- **Cost**: Free.
- **Cons**: Once a year; missing it means waiting 12 months.

### 백준 오픈 contests
- **What it is**: Community-organized contests on baekjoon.
- **Cost**: Free.
- **Pros**: Time-pressure practice.

---

## 6. Free Community Resources

- **tony9402/baekjoon** — Curated 백준 problem-by-category workbook. **High signal**; many use it as their backbone alongside CLASS. ([GitHub](https://github.com/tony9402/baekjoon))
- **안경잡이개발자 blog (나동빈)** — Author's blog with explanation walkthroughs.
- **bj-baekjoon / "CodeTest-Practice" GitHub solution repos** — Reference solutions across many people's accounts. Useful for comparing your approach; risky if you peek too early.
- **잔재미코딩 / 라이님 YouTube** — Various 비전공자-targeted YouTube channels; quality is mixed. **Verify recency before relying.**
- **solved.ac CLASS curation** — Effectively a free curriculum on top of 백준. CLASS 1-3 for beginners, CLASS 4-5 for actual 카카오/네이버 readiness.
- **kakao tech blog past-problem solutions** — Official walkthroughs of past Kakao 블라인드. Free, authoritative. ([tech.kakao.com](https://tech.kakao.com/posts/567))

---

## A. Opinionated Top Picks for This Profile

**Profile recap**: 비전공자, beginner, Python, 2 hrs/day, broad Korean target list.

### Recommended stack:

1. **Primary book — 이것이 취업을 위한 코딩 테스트다 (이코테)** + **동빈나 YouTube** (free companion). Still the right book #1 for a 비전공자 in Python. **Weeks 1-8.**
2. **Primary platform — 백준 단계별 → solved.ac CLASS 1-4** as the daily problem source, **and** **프로그래머스 카카오 기출 (Lv 2-3)** for Kakao/LINE prep. Both required.
3. **Accountability supplement — 항해99 99클럽** (~30,000 KRW for 5 weeks). The single best discipline-per-won spend in the entire market. Use during weeks 4-9.
4. **Phase 2 book (months 3-4) — 코딩 테스트 합격자 되기: 파이썬 편** (or **파이썬 알고리즘 인터뷰** if specifically aiming at Kakao/Naver hard).
5. **Optional power-up — 코드트리** (~49,000 KRW/month with 학생 인증, or **free if your university partners**). Check university first.

### Comparison to tentative plan (이코테 + 백준 + 프로그래머스 카카오 기출):

**Verdict: equivalent in core, missing two specific upgrades.**

- The core triad is genuinely best-in-class. Don't second-guess it.
- **Upgrade 1**: Add **항해99 99클럽** as a 30,000 KRW accountability layer.
- **Upgrade 2**: Use **solved.ac CLASS** as the curation overlay on 백준 (don't pick blindly). Target 백준 workbook 1152 (Samsung 기출) when ready for 구현.
- **Upgrade 3 (conditional)**: Check if your university gives free **코드트리** access.

Net: tentative plan is ~85% optimal. With the 3 upgrades, ~98% optimal.

---

## B. Overhyped / Skip-able

1. **종만북 (알고리즘 문제 해결 전략)** — C++, 2012-era, ICPC-tier, grossly overkill. **Skip entirely** unless competing in ICPC.
2. **Cracking the Coding Interview / Elements of Programming Interviews** — US-FAANG whiteboard-interview-coded. Korean coding tests are automated online judges. **Skip both until after coding test stage.**
3. **패스트캠퍼스 "네카라쿠배 끝장내는 파이썬 코딩테스트 마스터" (and 초격차 패키지)** — 300K-700K KRW for replaceable curriculum. **Skip unless you genuinely need 6-figure financial commitment for accountability** — and even then, 99클럽 at 30K does that job for 1/20 the price.

Honorable mention skips: **바킹독** (C++ only), **Princeton Algorithms** (Java, theoretical), **Codewars/HackerRank** (no Korean company tests there).
