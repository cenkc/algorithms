package algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 * Difficulty : Medium
 * Related Topics : Hash Table, String, Dynamic Programming, Trie, Memoization
 *
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Constraints:
 *
 *     1 <= s.length <= 300
 *     1 <= wordDict.length <= 1000
 *     1 <= wordDict[i].length <= 20
 *     s and wordDict[i] consist of only lowercase English letters.
 *     All the strings of wordDict are unique.
 *
 *
 * created by Cenk Canarslan on 2021-11-28
 */
public class WordBreak {

    @Test
    public void testWordBreak() {
        assertTrue(wordBreak("leetcode", Arrays.asList("leet", "code")));
        assertTrue(wordBreak("applepenapple", Arrays.asList("apple","pen")));
        assertFalse(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));

    }

    /**
     * Runtime: 7 ms, faster than 49.58% of Java online submissions for Word Break.
     * Memory Usage: 39.1 MB, less than 77.71% of Java online submissions for Word Break.
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
