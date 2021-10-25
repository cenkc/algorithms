package arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * HasAllUniqueChars
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_01_Is_Unique
 * Difficulty : Easy
 * Related Topics : Array, String
 *
 * created by Cenk Canarslan on 2021-10-24
 */
public class HasAllUniqueChars {
    @Test
    public void check() {
        HasAllUniqueChars hauc = new HasAllUniqueChars();
        assertTrue(hauc.hasAllUnique("cenkC"));
        assertFalse(hauc.hasAllUnique("cenkCan"));
    }

    private boolean hasAllUnique(String str) {
        boolean[] ascii_char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
//            System.out.println("char = '" + (char) value + "', value = " + value + ", i = " + i);
            if (ascii_char_set[value]) {
                return false;
            }
            ascii_char_set[value] = true;
        }
        return true;
    }
}
