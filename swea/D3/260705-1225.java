// [S/W 문제해결 기본] 7일차 - 암호생성기
// 0:21:45
import java.util.ArrayList;
import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        for (int test_case = 1; test_case <= 10; test_case++) {
            System.out.printf("#%d", sc.nextInt());
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (int i = 0; i < 8; i++) {
                nums.add(sc.nextInt());
            }
            boolean cont = true;
            outer: while (cont) {
                for (int i = 1; i <= 5; i++) {
                    int newNum = nums.remove(0) - i;
                    if (newNum <= 0) {
                        newNum = 0;
                        cont = false;
                        i = 5;
                    }
                    nums.add(nums.size(), newNum);
                }
            }
            for (int num : nums) {
                System.out.printf(" %d", num);
            }
            System.out.println();
        }
    }
}
