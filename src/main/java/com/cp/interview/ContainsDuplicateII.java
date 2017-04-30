package com.cp.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by curry on 4/29/17.
 */
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.get(nums[i]) != null && (i - map.get(nums[i])) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int items[] = {99,99};
        Boolean result = containsNearbyDuplicate(items, 2);
        System.out.println(result);
    }
}
