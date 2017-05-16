package com.cp.interview.bit;

/**
 * Created by curry on 5/11/17.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count =0;
        for(int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == 1 << i) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int test = 15;
        System.out.println(hammingWeight(test));
    }
}
