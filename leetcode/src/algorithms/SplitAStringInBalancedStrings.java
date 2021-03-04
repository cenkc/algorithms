package algorithms;

/**
 * 1221. Split a String in Balanced Strings
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * Difficulty : Easy
 * Related Topics : String, Greedy
 *
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * Example 4:
 *
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 *
 * created by Cenk Canarslan on 2021-01-17
 */
public class SplitAStringInBalancedStrings {

    /**
     * O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions
     * Memory Usage: 37.2 MB, less than 22.45% of Java online submissions
     *
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        if (s == null || s.isEmpty()) return 0;
        int count = 0;
        int lCount = 0, rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') lCount++;
            if (s.charAt(i) == 'R') rCount++;
            if (lCount == rCount) count++;
        }
        return count;
    }


//    /**
//     * O(n)
//     * Runtime: 1 ms, faster than 18.05% of Java online submissions
//     * Memory Usage: 37 MB, less than 37.09% of Java online submissions
//     *
//     * @param s
//     * @return
//     */
//    public int balancedStringSplit(String s) {
//        int count = 0;
//        Stack<Character> stack = new Stack<>();
//        stack.push(s.charAt(0));
//        for (int i = 1; i < s.length(); i++) {
//            char chr = s.charAt(i);
//            if (stack.isEmpty() || stack.peek() == chr) {
//                stack.push(chr);
//            } else {
//                if ( ! stack.isEmpty()) {
//                    stack.pop();
//                }
//            }
//            if (stack.isEmpty()){
//                count++;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        SplitAStringInBalancedStrings solution = new SplitAStringInBalancedStrings();
        System.out.println(solution.balancedStringSplit("RLRRLLRLRL")); // 4
        System.out.println(solution.balancedStringSplit("RLLLLRRRLR")); // 3
        System.out.println(solution.balancedStringSplit("LLLLRRRR")); // 1
        System.out.println(solution.balancedStringSplit("RLRRRLLRLL")); // 2
    }
}
