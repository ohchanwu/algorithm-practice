// 백만 장자 프로젝트
// ?
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.print("#" + test_case + " ");
            int N = sc.nextInt();
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = sc.nextInt();
            }
             
            long totalProfit = 0;
            int maxPrice = 0;
            for (int i = 0; i < N; i++) {
                int newPrice = prices[N-1-i];
                if (newPrice > maxPrice) {
                    maxPrice = newPrice;
                    continue;
                }
                totalProfit += maxPrice - newPrice;
            }
            System.out.println(totalProfit);
        }
    }
}
