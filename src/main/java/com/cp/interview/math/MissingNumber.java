package com.cp.interview.math;

/**
 * Created by curry on 6/6/17.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        int n=nums.length;
        return n*(n+1)/2-sum;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,7,8,9};
        System.out.println(missingNumber(nums));
    }
}
