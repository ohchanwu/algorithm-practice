// 5215. 햄버거 다이어트
// ? (didn't measure time)
// Using `BufferedReader`, `InputStreamReader`, and `StringTokenizer` instead of `Scanner`
// improved the execution time from 167ms -> 134ms (19.8% improvement).
import java.util.*;
import java.io.*;
 
class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int maxScore;
     
    public static void main(String args[]) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[][] ingredients = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }
             
            maxScore = 0;
             
            calcMaxScore(ingredients, N, L, 0, 0, 0);
             
            sb.append("#").append(test_case).append(" ").append(maxScore).append("\n");
        }
        System.out.println(sb);
    }
    static void calcMaxScore(int[][] ingredients, int N, int L, int i, int score, int calories) {
        if (calories > L) return;
        // maxScore must be updated here because even if i == N, 
        // it's the score from the previous index that's being added.
        maxScore = Math.max(maxScore, score);
        if (i >= N) return;
         
        // maxScore = Math.max(maxScore, score);
         
        calcMaxScore(ingredients, N, L, i + 1, score, calories);
        calcMaxScore(ingredients, N, L, i + 1, score + ingredients[i][0], calories + ingredients[i][1]);
    }
}
