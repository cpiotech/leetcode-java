package com.cp.interview;


import java.util.Arrays;

/**
 * Created by curry on 4/26/17.
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }

        return i+1;
    }
    public static void main(String[] args) {
        int items[] = {2, 3, 3, 4, 4};
        int result = removeDuplicates(items);
        System.out.println(result);
        System.out.println(Arrays.toString(items));
    }
}
