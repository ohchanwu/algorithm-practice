// Not complete
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
    static int numOfSwitches;
    static int[] scores;
    static int numOfScores;
    static int maxScore;
    static boolean[] visited;
    static int[] currPair = new int[2];
    

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	String scoresStr = st.nextToken();
        	numOfSwitches = Integer.parseInt(st.nextToken());
        	
        	scores = scoresStr.codePoints().toArray();
        	numOfScores = scores.length;
        	visited = new boolean[numOfScores];
        	
        	permutation(0);
        	
            sb.append('#')
                .append(t)
                .append(' ')
                .append(maxScore)
                .append('\n');
            
            maxScore = 0;
        }
        System.out.print(sb);
    }
    
    static void permutation(int depth) {
    	if (depth == 2) {
    		maxScore = Math.max(maxScore, calcScore());
    		return;
    	}
    	
    	for (int i = 0; i < numOfScores; i++) {
    		if (visited[i]) {
    			continue;
    		}
    		visited[i] = true;
    		permutation(depth+1);
    	}
    }
    
    static int calcScore() {
    	int[] scoreArrClone = scores.clone();
    	int temp = scoreArrClone[currPair[0]];
    	scoreArrClone[currPair[0]] = scoreArrClone[currPair[1]];
    	scoreArrClone[currPair[1]] = temp;
    	return Integer.parseInt(String.valueOf(scores));
    }
}
