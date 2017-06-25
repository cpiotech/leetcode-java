package com.cp.interview.search;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by curry on 6/15/17.
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0};
        System.out.println(largestNumber(nums));
    }
}
