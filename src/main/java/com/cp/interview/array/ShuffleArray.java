package com.cp.interview.array;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by curry on 8/26/17.
 */
public class ShuffleArray {
    public static class Solution {
        int[] original;
        int[] shuffled;
        Random r;

        public Solution(int[] nums) {
            original = nums;
            shuffled = Arrays.copyOf(nums,nums.length);
            r = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            shuffled=Arrays.copyOf(original, original.length);
            return shuffled;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int len = shuffled.length;

            for(int i=0; i<len; i++){
                int si = r.nextInt(len-i);
                int temp = shuffled[i];
                shuffled[i]=shuffled[si+i];
                shuffled[si+i]=temp;
            }

            return shuffled;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,-5,-9,1,5,8,3};
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
    }
}
