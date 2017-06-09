package com.cp.interview.bit;

/**
 * Created by curry on 6/3/17.
 */
public class FindDifference {
    public static char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ret ^= t.charAt(i);
        }
        return (char)ret;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abba", "abbda"));
        //System.out.println("c".charAt(0)^"c".charAt(0));
    }
}
