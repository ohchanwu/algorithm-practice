## 2026/07/06

1. 1216 (D3) - 회문2 - Current Status: 🟩 Comfortable - First Try Status: 🔴 AI-assisted
   - Worked on it for 1:02:22 before I gave up and asked Gemini what was wrong with my solution.
     - Turns out my general approach was correct, but I had made some code errors in the nested loops that prevented my solution from working properly.
   - Solved this in 19:20 unassisted on my 2nd attempt.
2. 1240 (D3) - 단순 2진 암호코드 - Current Status: 🟩 Comfortable - First Try Status: 🔴 Struggled
   - Took me 1:32:59 to solve this unassisted.
   - It was mainly because I took a long time to understand the prompt,
     and I made some mistakes when calculating indexes that took a long time to debug.
   - Took me 25:48 to solve this unassisted on my 2nd try.
     - Granted, I didn't have to read the prompt as much this time because I remembered most of it.

## 2026/07/05

1. 1873 (D3) - 상호의 배틀필드 - Current Status: 🟩 Comfortable - First Try Status: 🟥 Failed
   - Spent 45 minutes writing a messy solution. Ultimately stopped because I had to go home to call with Chloe.
   - Tried the problem again with a blank slate the next day.
     - Succeeded with a clean solution in 1:08:51, which I consider to be an acceptable time considering this is a challenging problem for D3.
     - That said, there are ways to streamline my code further. I should try the problem again.
   - Solved this on my 3rd attempt in 38:25.
2. 2805 (D3) - 농작물 수확하기 - Current Status: 🟩 Comfortable - First Try Status: 🟥 AI-assisted
   - Solved in 1:07:57 hours after some difficulty.
   - Struggled because I tried 2 approaches total:
     - First, I tried calculating the total row-by-row, determining the cells to read for each row.
     - I ditched that approach and went with diagonal linear scans.
   - Also struggled because I overlooked the fact that the numbers in each row of numbers weren't separated by spaces, so I used the usual method of initializing the matrix with `sc.nextInt()` in a loop, which caused memory errors.
     - I only found out the problem with Gemini's help.
   - Claude led me down a massive rabbit whole when it hallucinated saying that 파리퇴치 3's approach is applicable to this problem. It's not.
     - This trap cost me 1:22:25.
   - The right approach is **MANHATTAN DISTANCE**: calculating the distance of each cell from the center (disRows + disCols) and adding its value to the total if it's close enough.
     - Using this approach allowed me to solve this problem in approximately less than 10 minutes.

## 2026/07/04

1. 1954 (D2) - 달팽이 숫자 - Current Status: 🟩 Comfortable - First Try Status: 🟥 AI-assisted
   - Spent 2 hours writing a messy solution with Gemini's help.
   - 1 hour later, wrote a much cleaner version of the same solution unassisted.
   - 2 days later, wrote a clean solution unassisted in 0:13:07.

## 2026/07/03

1. 싸피 비전공 자율 (난이도 중, IM) - 숫자 배열 회전 - Current Status: 🟩 Comfortable - First Try Status: 🔴 Struggled
   - Took me 1 hour to solve this unassisted.
   - Afterwards, Gemini showed me cleaner solutions, which I implemented from memory.
   - 4 days later, implemented the cleaner and more efficient standard solution (reflect diagonally then vertically)

## 2026/07/02

1. 싸피 비전공 자율 (난이도 중, IM) - 파리퇴치3 - Current Status: 🟩 Comfortable - First Try Status: 🔴 Struggled
   - Took me over 2 hours to solve this unassisted.
   - Afterwards, Gemini showed me cleaner solutions, which I implemented from memory.
   - The next day, without much difficulty, I again implemented it from memory and solved a modified version of the problem with 1 more condition (blocking columns).
   - Solved it again 5 days later without much difficulty
