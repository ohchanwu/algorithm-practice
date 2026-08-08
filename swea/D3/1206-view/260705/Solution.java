// [S/W 문제해결 기본] 1일차 - View
// 0:28:42
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            System.out.printf("#%d ", test_case);
            int N = sc.nextInt();
            int[] buildings = new int[N];
            for (int i = 0; i < N; i++) {
                buildings[i] = sc.nextInt();
            }
            int totalDiff = 0;
            int[] neighbors = new int[] {-2, -1, 1, 2};
            for (int i = 2; i < N-2; i++) {
                int currB = buildings[i];
                int maxNeighbor = 0;
                for (int neighbor : neighbors) {
                    int neighborHeight = buildings[i + neighbor];
                    maxNeighbor = Math.max(maxNeighbor, neighborHeight);
                }
                if (currB - maxNeighbor > 0) {
                    totalDiff += currB - maxNeighbor;
                }
            }
            System.out.println(totalDiff);
        }
    }
}
