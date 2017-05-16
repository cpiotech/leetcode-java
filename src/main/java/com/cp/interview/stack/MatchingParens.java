package com.cp.interview.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by curry on 4/12/17.
 */
public class MatchingParens {
    public static int getMatchingParens(String sentence, int openingParenIndex) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        int openNestedParens = 0;
        for (int i = openingParenIndex + 1; i < sentence.length(); i++) {
            char curr = sentence.charAt(i);
            if (map.keySet().contains(curr)) {
                openNestedParens++;
            } else if (map.values().contains(curr)) {
               if (openNestedParens == 0) {
                   return i;
               } else {
                   openNestedParens--;
               }
            }
        }

        throw new IllegalArgumentException("No closing parenthesis :(");
    }
    public static void main(String[] args) {
        System.out.println(getMatchingParens("Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.", 10));
    }
}
