package com.cp.interview;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by curry on 4/30/17.
 */
/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }

        return null;
    }
    public static void main(String[] args) {
        int items[] = {2, 7, 11, 15};
        int[] result = twoSum(items, 9);
        System.out.println(Arrays.toString(result));
    }
}
