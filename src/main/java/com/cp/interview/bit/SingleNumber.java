package com.cp.interview.bit;

import java.util.Arrays;

/**
 * Created by curry on 4/19/17.
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i<nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int items[] = {2, 3, 5, 3, 2, 4 , 4};
        int result = singleNumber(items);
        System.out.println(result);
    }

}
