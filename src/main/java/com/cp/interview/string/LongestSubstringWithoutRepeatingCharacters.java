package com.cp.interview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by curry on 11/2/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> indexMap = new HashMap<>();
        int max = 0;
        int length = 0;
        int start = 0;
        for (int i =0; i < s.length(); i++) {
            if (indexMap.containsKey(s.charAt(i)) && indexMap.get(s.charAt(i)) >= start) {

                start = indexMap.get(s.charAt(i));
                length = i - start;
            } else {
                length++;
            }
            indexMap.put(s.charAt(i), i);
            max = Math.max(max, length);
        }

        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(lengthOfLongestSubstring("b"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
