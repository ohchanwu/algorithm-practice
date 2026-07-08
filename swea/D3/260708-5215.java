// 5215. 햄버거 다이어
// ? (didn't measure time)
import java.util.Scanner;
 
class Solution {
    static int maxScore;
     
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.printf("#%d ", test_case);
            int N = sc.nextInt();
            int L = sc.nextInt();
            int[][] ingredients = new int[N][2];
            for (int i = 0; i < N; i++) {
                ingredients[i][0] = sc.nextInt(); // score
                ingredients[i][1] = sc.nextInt(); // calories
            }
            maxScore = 0;
            calcScore(ingredients, N, L, 0, 0, 0);
            System.out.println(maxScore);
        }
    }
    static void calcScore(int[][] ingredients, int N, int L, int index, int score, int calories) {
        if (calories > L) return;
        if (index == N) {
            maxScore = Math.max(maxScore, score);
            return;
        }
         
        // calc next score with current ingredient included
        calcScore(ingredients, N, L, index + 1, score + ingredients[index][0], calories + ingredients[index][1]);
                   
        // calc next score with current ingredient excluded
        calcScore(ingredients, N, L, index + 1, score, calories);
    }
}
