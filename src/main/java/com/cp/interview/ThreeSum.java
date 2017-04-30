package com.cp.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.join;

/**
 * Created by curry on 4/16/17.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length<3)
            return result;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);
                        j++;
                        k--;
                        //handle duplicate here
                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (j < k && nums[k] == nums[k + 1])
                            k--;
                    } else if (nums[i] + nums[j] + nums[k] <= 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int items[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(items);
        result.forEach(r ->
            System.out.println(Arrays.toString(r.toArray())));
    }
}
