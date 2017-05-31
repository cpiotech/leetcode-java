package com.cp.interview.array;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by curry on 5/18/17.
 */
public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int candA = 0, candB = 0, countA = 0, countB = 0;
        for (int i =0; i < nums.length; i++) {
          if (candA == nums[i]) {
              countA++;
          } else if (candB == nums[i]) {
              countB++;
          } else if (countA == 0) {
              candA = nums[i];
              countA++;
          } else if (countB == 0) {
              candB = nums[i];
              countB++;
          } else {
              countA--;
              countB--;
          }
        }
        return Stream.of(candA, candB).distinct().filter(num -> {
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == num){
                    count++;
                }
            }
            return count > nums.length / 3;
        }).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        int[] nums = {1,5,1,5,1,5,1};
        majorityElement(nums).forEach(i -> System.out.println(i));
    }
}
