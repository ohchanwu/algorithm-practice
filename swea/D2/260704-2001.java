// 파리 퇴치
// ?
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.printf("#%d ", test_case);
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] matrix = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = sc.nextInt();
                }
            }
            int maxKC = 0;
            for (int r = 0; r < N-(M-1); r++) {
                for (int c = 0; c < N-(M-1); c++) {
                    int currKC = 0;
                    for (int subR = 0; subR < M; subR++) {
                        for (int subC = 0; subC < M; subC++) {
                            currKC += matrix[r+subR][c+subC];
                        }
                    }
                    maxKC = Math.max(maxKC, currKC);
                }
            }
            System.out.println(maxKC);
        }
    }
}
