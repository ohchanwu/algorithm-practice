import java.io.*;
import java.util.*;

public class Solution {
    // comment out this block before pasting into SWEA
    static {
        try {
            System.setIn(new FileInputStream("../input.txt"));
        } catch (Exception ignored) {}
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int N = 9;
    static int[] numsA = new int[N];
    static int[] numsB = new int[N];
    static int[] perm = new int[N];
    static boolean[] visited = new boolean[N];
    static int winCountA, loseCountA;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                numsA[n] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            outer:
            for (int i = 1; i <= 18; i++) {
                for (int j = 0; j < N; j++) {
                    if (numsA[j] == i) {
                        continue outer;
                    }
                }
                numsB[idx++] = i;
            }

            permutation(0);

            sb.append('#')
                .append(t)
                .append(' ')
                .append(winCountA)
                .append(' ')
                .append(loseCountA)
                .append('\n');

            winCountA = 0;
            loseCountA = 0;
        }
        System.out.print(sb);
    }

    static void permutation(int depth) {
        if (depth == N) {
            // perm[] has a full permutation
            calcWinner();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            perm[depth] = numsB[i];
            permutation(depth+1);

            // backtracking
            visited[i] = false;
        }
    }

    static void calcWinner() {
        int scoreA = 0;
        int scoreB = 0;
        // System.out.println(Arrays.toString(numsA));
        // System.out.println(Arrays.toString(perm));
        for (int i = 0; i < N; i++) {
            if (numsA[i] > perm[i]) {
                scoreA += numsA[i] + perm[i];
            } else {
                scoreB += numsA[i] + perm[i];
            }
        }
        if (scoreA > scoreB) {
            winCountA++;
        }
        if (scoreB > scoreA) {
            loseCountA++;
        }
    }
}
