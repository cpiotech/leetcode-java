package com.cp.interview.stack;

import java.util.Stack;

/**
 * Created by curry on 11/8/17.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i <= s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int[] a = {i, 0};
                stack.push(a);
            } else {
                if (stack.empty() || stack.peek()[1] == 1) {
                    int[] a = {i, 1};
                    stack.push(a);
                } else {
                    stack.pop();
                    int currentLen;
                    if (stack.empty()) {
                        currentLen = i + 1;
                    } else {
                        currentLen = i - stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")"));
    }
}
