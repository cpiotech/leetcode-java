package com.cp.interview.string;

/**
 * Created by curry on 7/12/17.
 */
public class ReverseStringII {
    public static String reverseWords(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("abcdefg", 2));
    }
}
