package com.cp.interview.array;

/**
 * Created by curry on 5/17/17.
 */
/*
https://leetcode.com/problems/majority-element/#/description
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        for (int i = 0,count = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                candidate = nums[i];
            } else if (candidate != nums[i]) {
                count--;
            } else {
                count++;
            }
        }

        return candidate;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,1,5,1,5,1};
        System.out.println(majorityElement(nums));
    }
}
