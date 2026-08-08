import java.io.*;
import java.util.*;

class Solution {
//	static {
//		try {
//			System.setIn(new FileInputStream("./input.txt"));
//		} catch (Exception e) {}
//	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] nums, sums;
	static int N, K, count;
	
	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			nums = new int[N];
			sums = new int[N];
			
			// populate arr with nums
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			// cache remaining sums at each idx to
			// prune impossible branches
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					sums[i] += nums[j];
				}
			}
			
			calcCount(0, 0);
			
			sb.append('#').append(test_case).append(' ').append(count).append('\n');
			
			nums = null;
			sums = null;
			count = 0;
			N = 0;
			K = 0;
		}
		System.out.println(sb);
	}
	
	static void calcCount(int idx, int sum) {
		if (sum == K) {
			count++;
			return;
		}
		if (sum > K) { return; }
		if (idx == N) { return; }
		if (sum + sums[idx] < K) { return; }
		
		// 2 branches, 1 incling the
		// curr node, and 1 excling it
		calcCount(idx+1, sum);
		calcCount(idx+1, sum+nums[idx]);
	}
}
