// 9229. 한빈이와 Spot Mart
// 0:14:32
import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.printf("#%d ", test_case);
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] bagWeights = new int[N];
            for (int i = 0; i < N; i++) {
                bagWeights[i] = sc.nextInt();
            }
             
            int maxPossible = -1;
            for (int i = 0; i < N; i++) {
                int currWeight = bagWeights[i];
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    int compWeight = bagWeights[j];
                    int combinedWeight = currWeight + compWeight;
                    if (combinedWeight <= M) maxPossible = Math.max(maxPossible, combinedWeight);
                }
            }
            System.out.println(maxPossible);
        }
    }
}
