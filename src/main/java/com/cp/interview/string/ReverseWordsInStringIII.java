package com.cp.interview.string;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

/**
 * Created by curry on 7/13/17.
 */
public class ReverseWordsInStringIII {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] words = s.split(" ");
        return String.join(" ", Arrays.stream(words).map(str -> reverseString(str)).collect(toList()));
    }
    public static String reverseString(String s) {
        char[] st = s.toCharArray();
        int startIndex = 0;
        int endIndex = st.length - 1;
        while (startIndex < endIndex) {
            char temp =  st[startIndex];
            st[startIndex] = st[endIndex];
            st[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

        return new String(st);
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's"));
    }
}
