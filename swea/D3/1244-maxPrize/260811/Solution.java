// approx 47:00
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
    static int[] scores;
    static int[] scoresClone;
    // Each top-level arr idx reps a branch layer,
    // and each str val is a state node that reps 
    // its branch in that layer.
    // Layers are based on num of swaps.
    static Set<String>[] seen;
    static int maxTotalScore;
    static int numOfSwaps;
 
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
             
            String scoreStr = st.nextToken();
            scores = scoreStr.chars().map((c) -> {
                return c - '0';
            }).toArray();
             
            numOfSwaps = Integer.parseInt(st.nextToken());
            seen = new HashSet[numOfSwaps];
            for (int i = 0; i < numOfSwaps; i++) {
                seen[i] = new HashSet<String>();
            }
             
            permutation(0);
             
            sb.append('#')
                .append(t)
                .append(' ')
                .append(maxTotalScore)
                .append('\n');
             
            maxTotalScore = 0;
        }
        System.out.print(sb);
    }
     
    static void permutation(int swaps) {
        if (swaps == 0) {
            scoresClone = scores.clone();
        }
        if (swaps == numOfSwaps) {
            calcMaxTotalScore();
            return;
        }
         
        if (seen[swaps].contains(Arrays.toString(scoresClone))) {
            return;
        }
        seen[swaps].add(Arrays.toString(scoresClone));
         
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores.length; j++) {
                if (j == i) continue;
                swap(i, j);
                permutation(swaps+1);
                 
                // backtracking
                swap(i, j);
            }
        }
    }
     
    static void swap(int i , int j) {
        int temp = scoresClone[i];
        scoresClone[i] = scoresClone[j];
        scoresClone[j] = temp;
    }
     
    static void calcMaxTotalScore() {
        int currTotalScore = 0;
        for (int i = 0; i < scores.length; i++) {
            currTotalScore += scoresClone[i] 
                    * Math.pow(10, scores.length - i - 1);
        }
        maxTotalScore = Math.max(maxTotalScore, currTotalScore);
    }
}
