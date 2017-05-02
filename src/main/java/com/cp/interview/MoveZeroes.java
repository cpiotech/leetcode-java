package com.cp.interview;

import java.util.Arrays;

/**
 * Created by curry on 4/30/17.
 */
/*
https://leetcode.com/problems/move-zeroes/#/description
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == 0){
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }

        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
    /*
    public void moveZeroes(int[] nums) {
    int m=-1;

    for(int i=0; i<nums.length; i++){
        if(nums[i]==0){
            if(m==-1 || nums[m]!=0){
                m=i;
            }
        }else{
            if(m!=-1){
                int temp = nums[i];
                nums[i]=nums[m];
                nums[m]=temp;
                m++;
            }
        }
    }
}
     */
    public static void main(String[] args) {
        int items[] = {0, 0, 2, 7, 11, 15};
        moveZeroes(items);
        System.out.println(Arrays.toString(items));
    }
}
