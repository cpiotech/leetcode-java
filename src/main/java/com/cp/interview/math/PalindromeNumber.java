package com.cp.interview.math;

import java.io.IOException;

/**
 * Created by curry on 9/8/17.
 */
public class PalindromeNumber {
    static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        // initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(isPalindrome(12321));
    }
}
