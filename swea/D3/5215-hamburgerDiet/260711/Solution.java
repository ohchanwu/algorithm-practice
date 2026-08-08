// 5215. 햄버거 다이어트
// ? (didn't measure time)
// Implementing early impossible branch detection and termination
// improved the execution time from 134ms -> 84ms (37.3% improvement).
import java.util.*;
import java.io.*;
 
class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int maxScore;
    static StringBuilder sb = new StringBuilder();
    static int[][] ingredients;
    static int[] cumTasteScore;
     
    public static void main(String args[]) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
             
            ingredients = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }
             
            cumTasteScore = new int[N];
            for (int i = N-1; i >= 0; i--) {
                if (i == N-1) {
                    cumTasteScore[i] = ingredients[i][0];
                    continue;
                }
                cumTasteScore[i] = cumTasteScore[i+1] + ingredients[i][0];
            }
             
            maxScore = 0;
            calcMaxScore(N, L, 0, 0, 0);
             
            sb.append('#').append(test_case).append(' ').append(maxScore).append('\n');
        }
        System.out.println(sb);
    }
     
    static void calcMaxScore(int N, int L, int idx, int score, int calories) {
        // terminate branch if calories exceed limit
        if (calories > L) return;
        maxScore = Math.max(maxScore, score);
        // after updating maxScore w previous ingredient's score
        // terminate branch if last index is reached
        if (idx == N) return;
        if (score + cumTasteScore[idx] <= maxScore) return;
         
        calcMaxScore(N, L, idx + 1, score, calories);
        calcMaxScore(N, L, idx + 1, score + ingredients[idx][0], calories + ingredients[idx][1]);
    }
}
