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

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            sb.append('#')
                .append(t)
                .append(' ')
                .append('\n');
        }
        System.out.print(sb);
    }
}
