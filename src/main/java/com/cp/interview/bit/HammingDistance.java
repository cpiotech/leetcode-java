package com.cp.interview.bit;

/**
 * Created by curry on 5/15/17.
 */
/*
https://leetcode.com/problems/hamming-distance/#/description
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count =0;
        for(int i = 0; i < 32; i++) {
            if ((result & (1 << i)) == 1 << i) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println((hammingDistance(1, 4)));
    }
}
