package arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Anagram
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_02_Check_Permutation
 * Difficulty : Easy
 * Related Topics : Array, String
 *
 * created by Cenk Canarslan on 2021-10-26
 */
public class Anagram {

    @Test
    public void checkIsAnagram() {
        Anagram anagram = new Anagram();
        assertFalse(anagram.isAnagram("", ""));
        assertFalse(anagram.isAnagram("", "aa"));
        assertFalse(anagram.isAnagram("bb", ""));
        assertFalse(anagram.isAnagram("c", "dd"));

        assertTrue(anagram.isAnagram("integral", "triangle"));
        assertFalse(anagram.isAnagram("integraL", "triangle"));
        assertTrue(anagram.isAnagram("silent", "listen"));
        assertFalse(anagram.isAnagram("Silent", "listen"));
    }

    private boolean isAnagram(String strA, String strB) {
        if (strA.length() == 0 || strB.length() == 0 || strA.length() != strB.length()) {
            return false;
        }

        int[] counter = new int[128];
        for (int i = 0; i < strA.length(); i++) {
            counter[strA.charAt(i)]++;
            counter[strB.charAt(i)]--;
        }
        for (int j = 0; j < 128; j++) {
            if (counter[j] != 0) {
                return false;
            }
        }
        return true;
    }

}
