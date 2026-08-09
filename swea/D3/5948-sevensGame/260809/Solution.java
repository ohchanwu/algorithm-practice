// 37:39
import java.io.*;
import java.util.*;

public class Solution {
    // comment out this block before pasting into SWEA
    // static {
    //     try {
    //         System.setIn(new FileInputStream("../input.txt"));
    //     } catch (Exception ignored) {}
    // }

    static final BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int N = 7;
    static final int R = 3;
    static final int[] nums = new int[N]; 
    static int fifthLargest = -1;
    static final int[] sums = new int[35];
    static int sumCount = 0;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            combination(0, 0, 0);

            Arrays.sort(sums);

            int nthLargest = 1;
            int prevVal = sums[34];
            for (int i = 34; i >= 0; i--) {
                if (sums[i] == prevVal) {
                    continue;
                }
                prevVal = sums[i];
                nthLargest++;
                if (nthLargest == 5) {
                    fifthLargest = sums[i];
                    break;
                }
            }

            sb.append('#')
                .append(t)
                .append(' ')
                .append(fifthLargest)
                .append('\n');
            
            fifthLargest = -1;
            sumCount = 0;
        }
        System.out.print(sb);
    }

    static void combination(int start, int depth, int sum) {
        if (depth == R) {
            sums[sumCount] = sum;
            sumCount++;
            return;
        }

        // dead-end branches pruned
        // via an upper loop bound
        for (int i = start; i < N-(R-1)+depth; i++) {
            combination(i+1, depth+1, sum+nums[i]);
        }
    }
}
