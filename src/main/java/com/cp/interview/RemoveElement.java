package com.cp.interview;

import java.util.Arrays;

/**
 * Created by curry on 4/27/17.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return nums.length;
        }
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }

        return i;
    }
    public static void main(String[] args) {
        int items[] = {2, 3, 3, 4, 4};
        int result = removeElement(items, 2);
        System.out.println(result);
        System.out.println(Arrays.toString(items));
    }
}
