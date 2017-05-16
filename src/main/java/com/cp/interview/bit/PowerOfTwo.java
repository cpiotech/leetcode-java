package com.cp.interview.bit;

/**
 * Created by curry on 5/14/17.
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n>0 && (n & -n) == n;
    }
    public static void main(String[] args) {
        int test = 0;
        System.out.println((isPowerOfTwo(test)));
    }
}
