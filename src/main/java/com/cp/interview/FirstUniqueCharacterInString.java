package com.cp.interview;

import java.util.HashMap;

/**
 * Created by curry on 4/30/17.
 */
public class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> scoreboard = new HashMap<>(); // build table [char -> count]
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (scoreboard.containsKey(c)) {
                scoreboard.put(c, scoreboard.get(c) + 1);
            } else {
                scoreboard.put(c, 1); }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (scoreboard.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String test = "leetcode";
        System.out.println(firstUniqChar(test));
    }
}
