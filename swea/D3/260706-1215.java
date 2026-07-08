// [S/W 문제해결 기본] 3일차 - 회문1
// 0:30:34
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
            System.out.printf("#%d ", test_case);
            int N = sc.nextInt();
			char[][] matrix = new char[8][8];
            for (int r = 0; r < 8; r++) {
                String line = sc.next();
                for (int c = 0; c < 8; c++) {
                    matrix[r][c] = line.charAt(c);
                }
            }
            // debugged until here
            int count = 0;
            // count horizontal palindromes
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8-(N-1); c++) {
                    char[] candidate = new char[N];
                    for (int i = 0; i < N; i++) {
                        candidate[i] = matrix[r][c + i];
                    }
                    char[] reversed = new char[N];
                    for (int i = 0; i < N; i++) {
                        reversed[i] = candidate[N-1-i];
                    }
                    if (Arrays.toString(candidate).equals(Arrays.toString(reversed))) {
                        count++;
                    }
                }
            }
            // count vertical palindromes
			for (int c = 0; c < 8; c++) {
                for (int r = 0; r < 8-(N-1); r++) {
                    char[] candidate = new char[N];
                    for (int i = 0; i < N; i++) {
                        candidate[i] = matrix[r + i][c];
                    }
                    char[] reversed = new char[N];
                    for (int i = 0; i < N; i++) {
                        reversed[i] = candidate[N-1-i];
                    }
                    if (Arrays.toString(candidate).equals(Arrays.toString(reversed))) {
                        count++;
                    }
                }
            }
            System.out.println(count);
		}
	}
}
