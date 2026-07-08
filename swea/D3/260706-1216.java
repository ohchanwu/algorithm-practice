// 1216. [S/W 문제해결 기본] 3일차 - 회문2
// 0:19:20 (2nd attempt)
import java.util.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            System.out.printf("#%d ", sc.nextInt());
            char[][] matrix = new char[100][100];
            for (int r = 0; r < 100; r++) {
                String line = sc.next();
                for (int c = 0; c < 100; c++) {
                    matrix[r][c] = line.charAt(c);
                }
            }
             
            int maxLen = 1;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int len = 0; j + len - 1 < 100; len++) {
                        if (isRowPalindrome(matrix, len, i, j)) maxLen = Math.max(maxLen, len);
                        if (isColPalindrome(matrix, len, j, i)) maxLen = Math.max(maxLen, len);
                    }
                }
            }
            System.out.println(maxLen);
        }
    }
     
    static boolean isRowPalindrome(char[][] matrix, int len, int r, int c) {
        int center = len / 2;
        for (int i = 0; i < center; i++) {
            if (matrix[r][c + i] != matrix[r][c + len - 1 - i]) return false;
        }
        return true;
    }
    static boolean isColPalindrome(char[][] matrix, int len, int r, int c) {
        int center = len / 2;
        for (int i = 0; i < center; i++) {
            if (matrix[r + i][c] != matrix[r + len - 1 - i][c]) return false;
        }
        return true;
    }
}
