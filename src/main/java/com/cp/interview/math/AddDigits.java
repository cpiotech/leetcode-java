package com.cp.interview.math;

/**
 * Created by curry on 6/9/17.
 */
public class AddDigits {
    public static int addDigits(int num) {
        int sum = 0;

        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            sum = sum + (Character.getNumericValue(s.charAt(i)));
        }

        if (sum < 10) {
            return sum;
        } else {
            return addDigits(sum);
        }
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
