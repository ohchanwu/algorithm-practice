// 상호의 배틀필드
// 1:08:51
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            System.out.printf("#%d ", test_case);
            
			int H = sc.nextInt();
            int W = sc.nextInt();
            int[][] matrix = new int[H][W];
            int[] currTankPos = new int[2];
            int currTankDr = 0;
            char currChar = '^';
            for (int r = 0; r < H; r++) {
                String line = sc.next();
				for (int c = 0; c < W; c++) {
                    currChar = line.charAt(c);
                    matrix[r][c] = currChar;
                    if (currChar == '^' || currChar == 'v' || currChar == '<' || currChar == '>') {
                        currTankPos[0] = r;
                        currTankPos[1] = c;
                        switch (currChar) {
                            case '^': currTankDr = 0; break;
                            case 'v': currTankDr = 1; break;
                            case '<': currTankDr = 2; break;
                            case '>': currTankDr = 3; break;
                        }
                    }
                }
            }
            int numOfMoves = sc.nextInt();
            String moves = sc.next();
            
            // up, down, left, right
            int[] drRows = new int[] {-1, 1, 0, 0};
            int[] drCols = new int[] {0, 0, -1, 1};
            
            for (int moveNum = 0; moveNum < numOfMoves; moveNum++) {
                char currMove = moves.charAt(moveNum);
                if (currMove == 'S') {
                    int[] currBulletPos = new int[2];
                    currBulletPos[0] = currTankPos[0];
                    currBulletPos[1] = currTankPos[1];
                    int[] newBulletPos = new int[2];
                    while (true) {
                        newBulletPos[0] = currBulletPos[0] + drRows[currTankDr];
                        newBulletPos[1] = currBulletPos[1] + drCols[currTankDr];
                        // if bullet goes out of bounds or meets a steel wall, nothing happens (end the loop)
                        if (newBulletPos[0] < 0 || newBulletPos[1] < 0 || newBulletPos[0] >= H || newBulletPos[1] >= W || matrix[newBulletPos[0]][newBulletPos[1]] == '#') {
                        	break;
                        }
                        if (matrix[newBulletPos[0]][newBulletPos[1]] == '*') {
                            matrix[newBulletPos[0]][newBulletPos[1]] = '.';
                            break;
                        }
                        currBulletPos[0] = newBulletPos[0];
                        currBulletPos[1] = newBulletPos[1];
                    }
                }
                // debugged until here
                if (currMove != 'S') {
                    switch (currMove) {
                        case 'U': currTankDr = 0; currChar = '^'; break;
                        case 'D': currTankDr = 1; currChar = 'v'; break;
                        case 'L': currTankDr = 2; currChar = '<'; break;
                        case 'R': currTankDr = 3; currChar = '>'; break;
                    }
                    int[] newTankPos = new int[2];
                    newTankPos[0] = currTankPos[0] + drRows[currTankDr];
                    newTankPos[1] = currTankPos[1] + drCols[currTankDr];
                    if (newTankPos[0] < 0 || newTankPos[1] < 0 || newTankPos[0] >= H || newTankPos[1] >= W || matrix[newTankPos[0]][newTankPos[1]] != '.') {
                        matrix[currTankPos[0]][currTankPos[1]] = currChar;
                    } else {
                        matrix[currTankPos[0]][currTankPos[1]] = '.';
                        matrix[newTankPos[0]][newTankPos[1]] = currChar;
                        currTankPos[0] = newTankPos[0];
                        currTankPos[1] = newTankPos[1];
                    }
                }
                // debugging
           		//for (int r = 0; r < H; r++) {
                //	for (int c = 0; c < W; c++) {
                //    	System.out.print(Character.toString((char) matrix[r][c]));
                //	}
                //	System.out.println();
            	//}
            }
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    System.out.print(Character.toString((char) matrix[r][c]));
                }
                System.out.println();
            }
		}
	}
}
