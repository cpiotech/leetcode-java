package com.cp.interview.bit;

/**
 * Created by curry on 5/19/17.
 */
public class PoweroOfFour {
    public static boolean isPowerOfFour(int num) {
        int count0 = 0;
        int count1 = 0;
        while (num > 0) {
            if ((num&1) == 1) {
                count1++;
            } else {
                count0++;
            }
            num>>=1;
        }
        return count1 == 1 && (count0 % 2 == 0);
    }
    public static void main(String[] args) {
        int test = 64;
        System.out.println((isPowerOfFour(test)));
    }
}
