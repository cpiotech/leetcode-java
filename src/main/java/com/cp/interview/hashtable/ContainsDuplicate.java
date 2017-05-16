package com.cp.interview.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by curry on 4/29/17.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums) {
            if (map.get(i) != null) {
                return true;
            } else {
                map.put(i, Boolean.TRUE);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int items[] = {2, 3, 5, 7, 8, 10};
        Boolean result = containsDuplicate(items);
        System.out.println(result);
    }
}
