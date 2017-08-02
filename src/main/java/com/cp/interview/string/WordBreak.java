package com.cp.interview.string;

import java.util.Arrays;
import java.util.List;

/**
 * Created by curry on 7/18/17.
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i])
                continue;

            for(String a: wordDict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }
    public static void main(String[] args) {
        String[] dicts = {"leet", "code"};
        System.out.println(wordBreak("leetcode", Arrays.asList(dicts)));
    }
}
