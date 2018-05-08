package com.cp.interview.array;

public class FindMinimumRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right])
            return nums[left];

        while (left <= right) {
            if (right - left == 1) {
                return nums[right];
            }

            int m = left + (right - left) / 2;

            if (nums[m] > nums[right])
                left = m;
            else
                right = m;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 10, 11, 12, 1};
        System.out.println(findMin(nums));
    }
}
