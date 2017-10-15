package com.cp.interview.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by curry on 9/23/17.
 */
/*
https://leetcode.com/problems/find-k-closest-elements/description/
 */
public class FindKClosestElements {
    //    static List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> ret = new ArrayList<>();
//        if (k == 0) {
//            return ret;
//        }
//
//        List<Integer> numList = IntStream.of(arr).boxed().collect(Collectors.toList());
//        Collections.sort(numList, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
//        ret = numList.subList(0, k);
//        Collections.sort(ret);
//        return ret;
//    }

    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> numList = IntStream.of(arr).boxed().collect(Collectors.toList());
        int n = numList.size();
        if (x <= numList.get(0)) {
            return numList.subList(0, k);
        } else if (numList.get(n - 1) <= x) {
            return numList.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(numList, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1);
            int high = Math.min(numList.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - numList.get(low)) <= (numList.get(high) - x))
                    high--;
                else if ((x - numList.get(low)) > (numList.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return numList.subList(low, high + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 7};
        System.out.println(findClosestElements(nums, 2, 4));
    }
}
