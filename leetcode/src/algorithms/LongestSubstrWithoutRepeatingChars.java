package algorithms;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Difficulty : Medium
 * Related Topics : HashTable, Two Pointers, String, Sliding Window
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * created by cenkc on 4/24/2020
 */
public class LongestSubstrWithoutRepeatingChars {

    public static void main(String[] args) {
        LongestSubstrWithoutRepeatingChars longestSubstrWithoutRepeatingChars
                = new LongestSubstrWithoutRepeatingChars();
        assertEquals(3, longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * <p><p>
     * <p><b>Example 1:</b>
     * <p>
     * <pre>{@code
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * }</pre>
     *
     * <p><b>Example 2:</b>
     * <p>
     * <pre>{@code
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * }</pre>
     *
     * <p><b>Example 3:</b>
     * <p>
     * <pre>{@code
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * }</pre>
     *
     * @param s String to find Longest Substring Without Repeating Characters
     * @return length of the Longest Substring Without Repeating Characters
     */
    public int lengthOfLongestSubstring(String s) {
        int lengthOfChars = 0;
        int windowStart = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (charMap.containsKey(s.charAt(windowEnd))) {
                windowStart = Math.max(charMap.get(s.charAt(windowEnd)), windowStart);
            }
            lengthOfChars = Math.max(lengthOfChars, windowEnd - windowStart + 1);
            charMap.put(s.charAt(windowEnd), windowEnd + 1);
        }
        return lengthOfChars;
    }
}
