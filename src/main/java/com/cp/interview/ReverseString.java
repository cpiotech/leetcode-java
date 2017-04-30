package com.cp.interview;

/**
 * Created by curry on 4/9/17.
 */
/*
https://leetcode.com/problems/reverse-string/#/description
 */
public class ReverseString {
    static public String reverseString(String s) {
        char[] st = s.toCharArray();
        int startIndex = 0;
        int endIndex = st.length - 1;
        while(startIndex < endIndex) {
            char temp =  st[startIndex];
            st[startIndex] = st[endIndex];
            st[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

        return new String(st);
    }
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}
