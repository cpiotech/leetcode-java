package com.cp.interview.array;

import java.util.Arrays;

/**
 * Created by curry on 5/30/17.
 */
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[nums.length-1]=1;
        for(int i=nums.length-2; i>=0; i--){
            result[i]=result[i+1]*nums[i+1];
        }

        int left=1;
        for(int i=0; i<nums.length; i++){
            result[i]=result[i]*left;
            left = left*nums[i];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
