// 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
// 25:48 (2nd try)
import java.util.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.printf("#%d ", test_case);
            // N = numOfRows, M = numOfCols;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] matrix = new int[N][M];
            for (int r = 0; r < N; r++) {
                String line = sc.next();
                for (int c = 0; c < M; c++) {
                    matrix[r][c] = Character.getNumericValue(line.charAt(c));
                }
            }
            int endRow = 0;
            int endCol = 0;
            outer: for (int r = N-1; r >= 0; r--) {
                for (int c = M-1; c >= 0; c--) {
                    if (matrix[r][c] == 1) {
                        endRow = r;
                        endCol = c;
                        break outer;
                    }
                }
            }
            int startCol = endCol - 55;
            String[] code = new String[8];
            Arrays.fill(code, "");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    code[i] += Integer.toString(matrix[endRow][startCol + (7 * i) + j]);
                }
            }
            int[] decrypted = new int[8];
            for (int i = 0; i < 8; i++) {
                switch (code[i]) {
                    case "0001101": decrypted[i] = 0; break;
                    case "0011001": decrypted[i] = 1; break;
                    case "0010011": decrypted[i] = 2; break;
                    case "0111101": decrypted[i] = 3; break;
                    case "0100011": decrypted[i] = 4; break;
                    case "0110001": decrypted[i] = 5; break;
                    case "0101111": decrypted[i] = 6; break;
                    case "0111011": decrypted[i] = 7; break;
                    case "0110111": decrypted[i] = 8; break;
                    case "0001011": decrypted[i] = 9; break;
                }
            }
            int total = 0;
            int testVal = 0;
            // index 0 is odd, index 1 is even
            for (int i = 0; i < 8; i++) {
                int decryptedVal = decrypted[i];
                total += decryptedVal;
                if (i % 2 == 0) testVal += 3 * decryptedVal;
                else testVal += decryptedVal;
            }
            if (testVal % 10 != 0) total = 0;
            System.out.println(total);
        }
    }
}
