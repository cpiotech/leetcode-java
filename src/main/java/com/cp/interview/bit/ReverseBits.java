package com.cp.interview.bit;

/**
 * Created by curry on 5/12/17.
 */
/*
https://leetcode.com/problems/reverse-bits/#/description
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++, n >>= 1){
            res = res << 1 | (n & 1);
        }
        return res;
    }
    public static void main(String[] args) {
        int test = 1;
        System.out.println(Integer.toBinaryString(test));
        System.out.println(reverseBits(test));
        System.out.println(Integer.toBinaryString(reverseBits(test)));
    }
}
