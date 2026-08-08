// 1234. [S/W 문제해결 기본] 10일차 - 비밀번호
// 0:23:36
import java.util.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            System.out.printf("#%d ", test_case);
            int N = sc.nextInt();
            String str = sc.next();
            ArrayList<Integer> intList = new ArrayList<Integer>();
            for (int i = 0; i < str.length(); i++) {
                intList.add(Character.getNumericValue(str.charAt(i)));
            }
            // debugged until here
            outer: while (true) {
                for (int i = 0; i < intList.size() - 1; i++) {
                    if (intList.get(i) == intList.get(i + 1)) {
                        intList.remove(i);
                        intList.remove(i);
                        break;
                    }
                    if (i == intList.size() - 2) {
                        break outer;
                    }
                }
            }
            String result = "";
            for (int num : intList) {
                result += Integer.toString(num);
            }
            System.out.println(result);
        }
    }
}
