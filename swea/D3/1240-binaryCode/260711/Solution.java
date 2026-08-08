// 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
// ? (didn't meausre time)
// Was assisted by the AI a bit in debugging this solution.
import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br; 
    static StringTokenizer st;
    static String codeLine;
    static String currLine;
    static char[] charArray;
    static int[] codeUnits;
    static StringBuilder sb = new StringBuilder();
    static int[] decodeMap = new int[128];
    
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        decodeMap[0b0001101] = 0;
        decodeMap[0b0011001] = 1;
        decodeMap[0b0010011] = 2;
        decodeMap[0b0111101] = 3;
        decodeMap[0b0100011] = 4;
        decodeMap[0b0110001] = 5;
        decodeMap[0b0101111] = 6;
        decodeMap[0b0111011] = 7;
        decodeMap[0b0110111] = 8;
        decodeMap[0b0001011] = 9;
        
        int T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            charArray = new char[W];
            codeLine = "";
            int endIndex = -1;
            for (int r = 0; r < H; r++) {
                currLine = br.readLine();
                if (codeLine == null || codeLine.isEmpty()) {
                    endIndex = currLine.lastIndexOf('1');
                    if (endIndex != -1) {
                        codeLine = currLine;
                        charArray = codeLine.toCharArray();
                    }
                }
            }
            if (endIndex == -1) throw new Exception("no 1 was found in the matrix");
            int startIndex = endIndex - 55;

            codeUnits = new int[8];
            int testTotal = 0;
            int total = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    codeUnits[i] = (codeUnits[i] << 1) + (charArray[startIndex + 7 * i + j] - '0');
                }
                // debugging
                // System.out.println(Integer.toString(codeUnits[i], 2));
                int decodedInt = decodeMap[codeUnits[i]];
                total += decodedInt;
                // an even index represents an odd position
                if (i % 2 == 0) testTotal += 3 * decodedInt;
                else testTotal += decodedInt;
            }
            System.out.println(testTotal);
            if (testTotal % 10 != 0) total = 0;
            
            sb.append('#').append(test_case).append(' ').append(total).append('\n');
        }

        System.out.println(sb);
	}
}
