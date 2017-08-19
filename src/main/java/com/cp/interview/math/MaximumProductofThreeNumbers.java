package com.cp.interview.math;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by curry on 8/19/17.
 */
public class MaximumProductofThreeNumbers {
    public static int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }

        // We're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        // we could also start these as null and check below if they're set
        // but this is arguably cleaner
        int highest = Math.max(nums[0], nums[1]);
        int lowest  = Math.min(nums[0], nums[1]);

        int highestProductOf2 = nums[0] * nums[1];
        int lowestProductOf2  = nums[0] * nums[1];

        // except this one--we pre-populate it for the first *3* items.
        // this means in our first pass it'll check against itself, which is fine.
        int highestProductOf3 = nums[0] * nums[1] * nums[2];

        // walk through items, starting at index 2
        for (int i = 2; i < nums.length; i++) {
            int current = nums[i];

            // do we have a new highest product of 3?
            // it's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(
                    highestProductOf3,
                    current * highestProductOf2),
                    current * lowestProductOf2);

            // do we have a new highest product of two?
            highestProductOf2 = Math.max(Math.max(
                    highestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new lowest product of two?
            lowestProductOf2 = Math.min(Math.min(
                    lowestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }
    public static void main(String[] args) {
        int[] nums = {3,-5,-9,1,5,8,3};
        System.out.println(maximumProduct(nums));

        /* Convert Primitive Array To List */
        List<Integer> myList = Arrays.stream(nums).boxed()
                .collect(Collectors.toList());
    }
}
