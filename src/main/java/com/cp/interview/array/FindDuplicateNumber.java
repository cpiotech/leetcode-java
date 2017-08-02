package com.cp.interview.array;

import java.util.Arrays;

/**
 * Created by curry on 7/16/17.
 */
/*
https://leetcode.com/problems/find-the-duplicate-number/#/description
 */
public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int l=1,r=nums.length-1;
        while(l<r){
            int m=(l+r)/2;
            int c=0;

            for(int i: nums){
                if(i<=m){
                    c++;
                }
            }

            //if c < m,
            if(c>m){
                r=m;
            }else{
                l=m+1;
            }
        }

        return r;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,1,4,4};
        System.out.println(findDuplicate(nums));
    }
}
