package com.cp.interview.amazonjp;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by curry on 9/5/17.
 */
public class IntegerToRomanArray {
    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }
    static String[] romanizer(int[] numbers) {
        if (numbers == null || numbers.length < 1 || numbers.length > 1000) {
            return new String[]{};
        }

        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = intToRoman(numbers[i]);
        }

        return result;
    }
    static String intToRoman(int num) {
        int floor = map.floorKey(num);
        if (num == floor) {
            return map.get(num);
        }
        return map.get(floor) + intToRoman(num - floor);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,8};
        System.out.println(Arrays.toString(romanizer(nums)));
    }
}
