package com.cp.interview.bit;

/**
 * Created by curry on 5/21/17.
 */
public class SumOfTwoIntegers {
    public static int getSum(int a, int b) {
        while (b != 0) {
            int c = a & b; //carry
            a ^= b; //add
            b = c << 1;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println((getSum(3,4)));
    }
}
