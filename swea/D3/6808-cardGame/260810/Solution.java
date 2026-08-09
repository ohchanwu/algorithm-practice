import java.io.*;
import java.util.*;

public class Solution {
    // comment out this block before pasting into SWEA
//    static {
//        try {
//            System.setIn(new FileInputStream("./input.txt"));
//        } catch (Exception ignored) {}
//    }

    static BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int N = 9;
    static int[] numsA = new int[N];
    static int[] unsortedNumsB = new int[N];
    static int[] sortedNumsB = new int[N];
    static int winCountB = 0;
    static int loseCountB = 0;
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int i = 0; i < N; i++) {
        		numsA[i] = Integer.parseInt(st.nextToken());
        	}
        	
//        	System.out.println(Arrays.toString(numsA));
        	int idxCount = 0;
        	outer: for (int i = 1; i <= 18; i++) {
        		for (int j = 0; j < N; j++) {
        			if (i == numsA[j]) continue outer;
        		}
        		unsortedNumsB[idxCount++] = i;
//        		System.out.println(Arrays.toString(unsortedNumsB));
        	}
        	
        	permutation(0);
        	
            sb.append('#')
                .append(t)
                .append(' ')
                .append(loseCountB)
            	.append(' ')
            	.append(winCountB)
                .append('\n');
            
            winCountB = 0;
            loseCountB = 0;
//            Arrays.fill(numsA, -1);
//            Arrays.fill(unsortedNumsB, -1);
//            Arrays.fill(sortedNumsB, -1);
        }
        System.out.print(sb);
    }
    
    static void permutation(int depth) {
    	if (depth == N) {
    		calcCount();
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		if (visited[i]) {
    			continue;
    		}
    		visited[i] = true;
    		
    		sortedNumsB[depth] = unsortedNumsB[i];
    		permutation(depth+1);
    		
    		// backtracking
    		visited[i] = false;
    	}
    }
    
    static void calcCount() {
    	int scoreA = 0;
    	int scoreB = 0;
    	for (int i = 0; i < N; i++) {
    		if (numsA[i] > sortedNumsB[i]) {
    			scoreA += numsA[i] + sortedNumsB[i];
    		}
    		if (sortedNumsB[i] > numsA[i]) {
    			scoreB += numsA[i] + sortedNumsB[i];
    		}
    	}
    	if (scoreA > scoreB) loseCountB++;
    	if (scoreB > scoreA) winCountB++;
    }
}
