// [S/W 문제해결 기본] 5일차 - Magnetic
// 0:31:57
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
             
            // initialize matrix
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = sc.nextInt();
                }
            }
            // make moves
            for (int moves = 1; moves > 0;) {
                moves = 0;
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        int currCellVal = matrix[r][c];
                        if (currCellVal == 0) {
                            continue;
                        }
                        if (currCellVal == 1) {
                            // ones go down
                            int nextRow = r + 1;
                            if (nextRow < 100 && matrix[nextRow][c] == 0) {
                                matrix[nextRow][c] = 1;
                                matrix[r][c] = 0;
                                moves += 1;
                            }
                            if (nextRow >= 100) {
                                matrix[r][c] = 0;
                                moves += 1;
                            }
                        }
                        if (currCellVal == 2) {
                            // twos go up
                            int nextRow = r - 1;
                            if (nextRow >= 0 && matrix[nextRow][c] == 0) {
                                matrix[nextRow][c] = 2;
                                matrix[r][c] = 0;
                                moves += 1;
                            }
                            if (nextRow < 0) {
                                matrix[r][c] = 0;
                                moves += 1;
                            }
                        }
                    }
                }
            }
            // calculate result
            int result = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (matrix[r][c] == 1) {
                        result = (matrix[r+1][c] == 2) ? result + 1 : result;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
