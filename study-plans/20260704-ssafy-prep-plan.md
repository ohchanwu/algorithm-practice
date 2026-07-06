## ✅ Day 1 — 2D array core (attack the weak spot):

1. ✅ 1209 Sum (63%) — row/column/diagonal sums; gentle 2D indexing warmup
   - Solved in 27:27 minutes without much difficulty.
2. ✅ 2805 농작물 수확하기 (77%) — diamond-region traversal, i.e. 파리퇴치3's exact pattern on a new problem; this tests whether that review actually stuck
   - Solved in 1:07:57 hours after some difficulty.
   - Struggled because I tried 2 approaches total:
     - First, I tried calculating the total row-by-row, determining the cells to read for each row.
     - I ditched that approach and went with diagonal linear scans.
   - Also struggled because I overlooked the fact that the numbers in each row of numbers weren't separated by spaces, so I used the usual method of initializing the matrix with `sc.nextInt()` in a loop, which caused memory errors.
     - The memory errors occured from unintentionally attempting to allocate memory for 2D arrays like `new int[~14000][~14000]`.
     - I mistook these memory errors for index out of bounds errors (since the same message occurs for both), so I was looking at the wrong place.
     - Finally, I asked Gemini what the problem was, and it made me realize the problem was in the way I was initializing the matrix.
   - Also, I'm not sure how the 파리퇴치 approach is applicable to this problem.
3. ✅ 1206 View (64%) — the classic window scan; a "1일차" staple
   - Solved in 28:42 minutes after some trial and error.
   - Variable names were messy though.
   - Ran into a technical issue where the site was taking too long to compile my code,
     so I refreshed the page but that erased some of my progress.
     Probably cost me around 3 minutes.
4. ✅ 1220 Magnetic (78%) — column-wise state scan
   - Solved in 31:57 minutes without too much difficulty.
   - But my 1st solution was unoptimized - O(iterations × N²)
   - Gemini suggested a more efficient approach - O(N²) - will try later.

## Day 2 — grid simulation (the IM signature):

1. ✅ 1225 암호생성기 (77%) — queue rotation cycle
   - Solved in 21:45 minutes without much difficulty.
   - Used an `ArrayList` because my approach required repeatedly shifting 1 element from the start of the array, modifying that element, and pushing it onto the end of the array.
   - I know that using a doubly linked list (`LinkedList`) or an `ArrayDeque` would be more efficient, but I don't know those classes' methods.
2. ✅ 1873 상호의 배틀필드 (52%) — tank-on-a-grid simulation with directions; the closest D3 to a real IM problem's feel
   - Solved in 1:08:51 unassisted on my 2nd attempt.
   - It's a D3 problem, but harder on the IM side.
   - That said, there are ways to streamline my code further. I should try the problem again.
3. 4615 재미있는 오셀로 게임 (39%) — 8-direction flip simulation; hardest of the grid set, do it while fresh
   - Skipping this for now since it's too difficult to be representative of 분반테스트 IM problems.

## Day 3 — strings and stacks/lists:

1. 1215 회문1 (79%) then 1216 회문2 (60%) — palindrome scans over a char grid (2D again, on purpose)
2. 1240 단순 2진 암호코드 (75%) — string parsing/decoding
3. 1234 비밀번호 (76%) — stack-based pair removal

## Day 4 — 완전탐색 (brute-force search) + review:

1. 9229 한빈이와 Spot Mart (56%) — pair brute force
2. 5215 햄버거 다이어트 (52%) — subset search; the canonical 완전탐색 D3
3. 2817 부분 수열의 합 (56%) — reinforces subsets
4. Then stop adding new problems: re-solve 파리퇴치3, 숫자 배열 회전, and 달팽이 숫자 cold, since the official Solving Club problems are the closest known proxy to the actual test.
