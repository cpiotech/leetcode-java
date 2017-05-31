package com.cp.interview.array;

/**
 * Created by curry on 5/22/17.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            max = Math.max(max, sum[i]);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,1,5,1,5,1};
        System.out.println(maxSubArray(nums));
    }
}
