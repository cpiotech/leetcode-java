package com.cp.interview.stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by curry on 9/3/17.
 */
/*
https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
 */
public class BalancedBrackets {
    public static boolean isBalanced(String expression) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
