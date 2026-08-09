// Testing to see how much overhead the TreeSet and Stream
// API usage creates.
// Approximately doubled the time complexity
// from 143ms -> 275ms
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
    static final TreeSet<Integer> sums = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            combination(0, 0, 0);

            fifthLargest = sums.descendingSet()
                .stream()
                .skip(4)
                .findFirst()
                .get();

            sb.append('#')
                .append(t)
                .append(' ')
                .append(fifthLargest)
                .append('\n');
            
            fifthLargest = -1;

            sums.clear();
        }
        System.out.print(sb);
    }

    static void combination(int start, int depth, int sum) {
        if (depth == R) {
            sums.add(sum);
            return;
        }

        // dead-end branches pruned
        // via an upper loop bound
        for (int i = start; i < N-(R-1)+depth; i++) {
            combination(i+1, depth+1, sum+nums[i]);
        }
    }
}
