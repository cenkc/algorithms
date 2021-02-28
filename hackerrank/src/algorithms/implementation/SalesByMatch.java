package algorithms.implementation;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * Sales by Match
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 * Difficulty : Easy
 * Related Topics : Arrays
 *
 * created by Cenk Canarslan on 2021-02-27
 */
public class SalesByMatch {

    static int sockMerchant(int n, int[] ar) {
        Set<Integer> bucket = new HashSet<>();

        int counter = 0;
        for (int i = 0; i < ar.length; i++) {
            if (!bucket.contains(ar[i])) {
                bucket.add(ar[i]);
            } else {
                counter++;
                bucket.remove(ar[i]);
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int result = sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        Assert.assertEquals(3, result);
    }
}
