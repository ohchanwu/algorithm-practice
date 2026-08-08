import java.io.*;
import java.util.*;

public class Solution {
    static {
        try {
            System.setIn(new FileInputStream("../input.txt"));
        } catch (Exception ignored) {}
    }

    static final BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final StringBuilder sb = new StringBuilder();
    static final TreeSet<Integer> sums = new TreeSet<>();
    static final int N = 7;
    static final int K = 3;
    static final int[] nums = new int[N];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            combinations(0, 0, 0);

            Integer fifthLargest = sums.descendingSet()
                .stream()
                .skip(4)
                .findFirst()
                .get();

            sb.append('#').append(t).append(' ').append(fifthLargest).append('\n');

            sums.clear();
        }
        System.out.println(sb);
    }

    static void combinations(int start, int depth, int sum) {
        if (depth == K) {
            sums.add(sum);
            return;
        }

        for (int i = start; i < N; i++) {
            combinations(i+1, depth+1, sum+nums[i]);
        }
    }
}
