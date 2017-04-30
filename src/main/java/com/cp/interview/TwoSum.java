package com.cp.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by curry on 4/17/17.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[]{0,1};
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                index[1] = i;
                index[0] = hm.get(target-nums[i]);
                return index;
            } else {
                hm.put(nums[i],i);
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int items[] = {0, 7, 2, 1};
        int[] result = twoSum(items, 9);
        System.out.println(Arrays.toString(result));
    }
}
