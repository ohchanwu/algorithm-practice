// [S/W 문제해결 기본] 2일차 - Sum
// 0:27:27
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        // right, down, downright, downleft
        // int[] drRows = new int[] {0, 1, 1, 1};
        // int[] drCols = new int[] {1, 0, 1, -1};
         
        for (int test_case = 1; test_case <= 10; test_case++)    {
            System.out.printf("#%d ", sc.nextInt());
            int[][] matrix = new int[100][100];
            int maxCount = 0;
            // populate matrix and calc row counts at the same time
            for (int r = 0; r < 100; r++) {
                int currRowCount = 0;
                for (int c = 0; c < 100; c++) {
                    int currCellCount = sc.nextInt();
                    matrix[r][c] = currCellCount;
                    currRowCount += currCellCount;
                }
                maxCount = Math.max(maxCount, currRowCount);
            }
            // calc column counts
            for (int c = 0; c < 100; c++) {
                int currColCount = 0;
                for (int r = 0; r < 100; r++) {
                    currColCount += matrix[r][c];
                }
                maxCount = Math.max(maxCount, currColCount);
            }
            int downRightCount = 0;
            for (int steps = 0; steps < 100; steps++) {
                downRightCount += matrix[steps][steps];
            }
            int downLeftCount = 0;
            for (int steps = 0; steps < 100; steps++) {
                downLeftCount += matrix[steps][99-steps];
            }
            System.out.println(Math.max(maxCount, Math.max(downRightCount, downLeftCount)));
        }
    }
}
