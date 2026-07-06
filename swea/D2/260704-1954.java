// 달팽이 숫자
// ?
import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // right, down, left, up
        int[] drRows = new int[] {0, 1, 0, -1};
        int[] drCols = new int[] {1, 0, -1, 0};
         
        for (int t = 1; t <= T; t++) {
            System.out.printf("#%d\n", t);
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
             
            int r = 0;
            int c = 0;
            int currDr = 0;
            for (int i = 1; i <= N*N; i++) {
                matrix[r][c] = i;
                 
                int newR = r + drRows[currDr];
                int newC = c + drCols[currDr];
                if (newR < 0 || newC < 0 || newR >= N || newC >= N || matrix[newR][newC] != 0) {
                    currDr = (currDr + 1) % 4;
                    newR = r + drRows[currDr];
                    newC = c + drCols[currDr];
                }
                 
                r = newR;
                c = newC;
                // debugging
                // System.out.println("move" + i);
            }
             
            for (r = 0; r < N; r++) {
                for (c = 0; c < N; c++) {
                    System.out.print(matrix[r][c]);
                    if (c < N-1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
