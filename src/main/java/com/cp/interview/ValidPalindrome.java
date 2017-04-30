package com.cp.interview;

/**
 * Created by curry on 4/10/17.
 */
/*
https://leetcode.com/problems/valid-palindrome/#/description
 */
public class ValidPalindrome {
    //  check if current character is valid
    private static boolean isValid(char c){
        if ('a'<=c && c<='z')
            return true;

        if ('0'<=c && c<='9')
            return true;

        return false;
    }
    public static boolean isPalindrome(String s) {
        char[] st = s.toLowerCase().toCharArray();
        int startIndex = 0;
        int endIndex = st.length - 1;
        while (endIndex > startIndex) {
            while(startIndex < endIndex && !isValid(st[startIndex]))
            {
                startIndex++;
            }
            // Skip all invalid character
            while(startIndex < endIndex && !isValid(st[endIndex]))
            {
                endIndex--;
            }
            if (st[startIndex] != st[endIndex]) {
                return false;
            }

            ++startIndex;
            --endIndex;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
