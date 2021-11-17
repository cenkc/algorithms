package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 * Difficulty : Medium
 * Related Topics : String, Dynamic Programming
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 *
 * created by Cenk Canarslan on 2021-11-17
 */
public class LongestCommonSubsequence {

    @Test
    public void testLongestCommonSubsequence() {

        /**
         * Longest Common Subsequence with Recursion
         * Be caref
         */
        assertEquals(3, lcsWithRecursion("abcde", "ace"));
        assertEquals(3, lcsWithRecursion("abc", "abc"));
        assertEquals(0, lcsWithRecursion("abc", "def"));
        assertEquals(2, lcsWithRecursion("aab", "azb"));
        assertEquals(2, lcsWithRecursion("bd", "abcd"));
        assertEquals(4, lcsWithRecursion("aggtab", "gxtxayb"));
        // Takes ~20 seconds !!!!
        // assertEquals(4, lcsWithRecursion("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));

        /**
         * Longest Common Subsequence with Recursion & Memoization
         */
        assertEquals(3, lcsWithRecursionAndMemoization("abcde", "ace"));
        assertEquals(3, lcsWithRecursionAndMemoization("abc", "abc"));
        assertEquals(0, lcsWithRecursionAndMemoization("abc", "def"));
        assertEquals(2, lcsWithRecursionAndMemoization("aab", "azb"));
        assertEquals(2, lcsWithRecursionAndMemoization("bd", "abcd"));
        assertEquals(4, lcsWithRecursionAndMemoization("aggtab", "gxtxayb"));
        // Takes 2.2 milliseconds
        assertEquals(4, lcsWithRecursionAndMemoization("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));

        /**
         * Longest Common Subsequence with Dynamic Programming
         */
        assertEquals(3, lcsWithDynamicProgramming("abcde", "ace"));
        assertEquals(3, lcsWithDynamicProgramming("abc", "abc"));
        assertEquals(0, lcsWithDynamicProgramming("abc", "def"));
        assertEquals(2, lcsWithDynamicProgramming("aab", "azb"));
        assertEquals(2, lcsWithDynamicProgramming("bd", "abcd"));
        assertEquals(4, lcsWithDynamicProgramming("aggtab", "gxtxayb"));
        // Takes 0.18 milliseconds :)
        assertEquals(4, lcsWithDynamicProgramming("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
//        String s1 = "bd";
//        String s2 = "abcd";
//        String s1 = "aggtab";
//        String s2 = "gxtxayb";
        String s1 = "pmjghexybyrgzczy";
        String s2 = "hafcdqbgncrcbihkd";
        long start = System.nanoTime();
//        int result = lcs.lcsWithRecursion(s1, s2);
//        int result = lcs.lcsWithRecursionAndMemoization(s1, s2);
        int result = lcs.lcsWithDynamicProgramming(s1, s2);
        long end = System.nanoTime();
        System.out.println("result = " + result + ", time = " + (end - start));
    }

    /**
     * Dynamic Programming
     *
     * Runtime: 10 ms, faster than 72.06% of Java online submissions for Longest Common Subsequence.
     * Memory Usage: 42.8 MB, less than 63.83% of Java online submissions for Longest Common Subsequence.
     *
     * @param s1
     * @param s2
     * @return
     */
    public int lcsWithDynamicProgramming(String s1, String s2) {
        int[][] dpTable = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dpTable[i][j] = 1 + dpTable[i-1][j-1];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i-1][j], dpTable[i][j-1]);
                }
            }
        }
        return dpTable[s1.length()][s2.length()];
    }

    /**
     * Recursive with memoization
     *
     * Runtime: 29 ms, faster than 14.11% of Java online submissions for Longest Common Subsequence.
     * Memory Usage: 43.5 MB, less than 17.18% of Java online submissions for Longest Common Subsequence.
     *
     * @param s1
     * @param s2
     * @return
     */
    public int lcsWithRecursionAndMemoization(String s1, String s2) {
        int[][] memo = new int[s1.length()][s2.length()];
        return sub(s1, s2, 0, 0, memo);
    }

    private int sub(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int result;
        if (s1.charAt(i) == s2.charAt(j)) {
            result = 1 + sub(s1, s2, i+1, j+1, memo);
        } else {
            result = Math.max(sub(s1, s2, i, j+1, memo),
                    sub(s1, s2, i+1, j, memo));
        }
        memo[i][j] = result;
        return result;
    }

    /**
     * Recursive
     *
     * Time limit exceeded !!
     *
     * @param s1
     * @param s2
     * @return
     */
    public int lcsWithRecursion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        } else if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
            return 1 + lcsWithRecursion(s1.substring(0, s1Len - 1), s2.substring(0, s2Len - 1));
        } else {
            return Math.max(lcsWithRecursion(s1.substring(0, s1Len - 1), s2),
                    lcsWithRecursion(s1, s2.substring(0, s2Len - 1)));
        }
    }
}
