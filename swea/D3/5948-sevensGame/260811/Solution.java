// 27:00
// Tried a new strat for combinations
import java.io.*;
import java.util.*;

public class Solution {
    // comment out this block before pasting into SWEA
    static {
        try {
            System.setIn(new FileInputStream("../input.txt"));
        } catch (Exception e) {
        	try {
        		System.setIn(new FileInputStream("./input.txt"));
        	} catch (Exception e2) {
        		System.out.println("input.txt not found");
        	}
        }
    }

    static BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N = 7;
    static int[] nums = new int[N];
    static int[] sums = new int[35];

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    for (int k = j+1; k < N; k++) {
                        sums[count] = nums[i] + nums[j] + nums[k];
                        count++;
                    }
                }
            }

            Arrays.sort(sums);
            int result = Integer.MAX_VALUE;
            count = 0;
            for (int i = sums.length-1; i >= 0; i--) {
                if (sums[i] < result) {
                    result = sums[i];
                    count++;
                }
                if (count == 5) break;
            }

            sb.append('#')
                .append(t)
                .append(' ')
                .append(result)
                .append('\n');
        }
        System.out.print(sb);
    }
}
