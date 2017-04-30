package com.cp.interview;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by curry on 4/10/17.
 */
/*
https://leetcode.com/problems/valid-parentheses/#/description
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            } else{
                return false;
            }
        }

        return stack.empty();
    }
    public static void main(String[] args) {
        System.out.println(isValid(" "));
    }
}
