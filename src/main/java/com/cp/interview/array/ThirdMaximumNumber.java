package com.cp.interview.array;

/**
 * Created by curry on 5/31/17.
 */
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            }
            else if (num > second && num < first) {
                third = second;
                second = num;
            }
            else if (num > third && num < second) {
                third = num;
            }
        }

        return third == Long.MIN_VALUE ?  (int)first: (int)third;
    }
    public static void main(String[] args) {
        int[] nums = {5,5,2,2,1};
        System.out.println(thirdMax(nums));
    }
}
