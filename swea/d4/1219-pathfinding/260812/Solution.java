import java.io.*;
import java.util.*;

public class Solution {
    // comment out this block before pasting into SWEA
//    static {
//        try {
//            System.setIn(new FileInputStream("../input.txt"));
//        } catch (Exception e) {
//        	try {
//        		System.setIn(new FileInputStream("./input.txt"));
//        	} catch (Exception e2) {
//        		System.out.println("input.txt not found");
//        	}
//        }
//    }

    static BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] graph = new int[100][2];
    static int result = 0;

    public static void main(String[] args) throws Exception {
        for (int t = 1; t <= 10; t++) {
        	for (int i = 0; i < 100; i++) {
        		Arrays.fill(graph[i], -1);
        	}
        	
            st = new StringTokenizer(br.readLine());
        	st.nextToken();
        	int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	int from = Integer.parseInt(st.nextToken());
            	if (graph[from][0] == -1) {
            		graph[from][0] = Integer.parseInt(st.nextToken());
            	} else {
            		graph[from][1] = Integer.parseInt(st.nextToken());
            	}
            }
//            System.out.println(Arrays.toString(graph[0]));
            
            dfs(0);
            
            sb.append('#')
                .append(t)
                .append(' ')
                .append(result)
                .append('\n');
            
            result = 0;
        }
        System.out.print(sb);
    }
    
    static void dfs(int fromVertex) {
    	if (fromVertex == -1) return;
    	
    	int toVertex1 = graph[fromVertex][0];
//    	System.out.println(fromVertex + " " + toVertex1);
    	int toVertex2 = -1;
    	if (graph[fromVertex][1] != -1) {
    		toVertex2 = graph[fromVertex][1];
    	}
    	
    	if (toVertex1 == 99 || toVertex2 == 99) {
    		result = 1;
    		return;
    	}
    	
    	dfs(toVertex1);
    	if (toVertex2 != -1) {
    		dfs(toVertex2);
    	}
    }
}
