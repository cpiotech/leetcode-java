package com.cp.interview.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by curry on 6/1/17.
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");

        //prevent out of boundary problem
        if (arr.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String value = map.get(c);
                if (!value.equals(arr[i])) {
                    return false;
                }
            } else if (map.containsValue(arr[i])) {
                return false;
            }
            map.put(c, arr[i]);
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
