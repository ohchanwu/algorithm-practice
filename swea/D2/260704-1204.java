// [S/W 문제해결 기본] 1일차 - 최빈수 구하기
// ?
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.printf("#%d ", sc.nextInt());
            // each index represents a score
            // index 0 is left empty
            int[] scores = new int[1001];
             
            for (int i = 0; i < 1000; i++) {
                scores[sc.nextInt()] += 1;
            }
             
            int maxCount = 0;
            int mostCommonScore = 0;
            for (int i = 1; i <= 1000; i++) {
                if (maxCount < scores[i]) {
                    maxCount = scores[i];
                    mostCommonScore = i;
                }
                if (maxCount == scores[i]) {
                    mostCommonScore = Math.max(mostCommonScore, i);
                }
            }
             
            System.out.println(mostCommonScore);
        }
    }
}
