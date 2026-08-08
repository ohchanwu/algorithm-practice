// 농작물 수확하기
// 1:07:57
import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            // populate matrix
            for (int r = 0; r < N; r++) {
                String str = sc.next();
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = Character.getNumericValue(str.charAt(c));
                }
            }
            int center = N / 2 + 1;
            int total = 0;
            for (int i = 0; i < center; i++) {
                int startRow = i;
                int startCol = center - 1 + i;
                for (int j = 0; j < center; j++) {
                    int row = startRow + j;
                    int col = startCol - (1 * j);
                    total += matrix[row][col];
                }
            }
            for (int i = 1; i < center; i++) {
                int startRow = i;
                int startCol = center - 2 + i;
                for (int j = 0; j < center-1; j++) {
                    int row = startRow + j;
                    int col = startCol - (1 * j);
                    total += matrix[row][col];
                }
            }
            System.out.printf("#%d %d\n", test_case, total);
        }
    }
}
