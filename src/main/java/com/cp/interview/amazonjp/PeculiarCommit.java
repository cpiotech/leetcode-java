package com.cp.interview.amazonjp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by curry on 9/5/17.
 */
public class PeculiarCommit {
    static int countPeculiarStrings(String s) {
        int countEven = 0;
        int countOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            countEven += getPeculiars(s, i, i + 1);
            countOdd += getPeculiars(s, i, i);
        }

        return countEven + countOdd;
    }

    static int getPeculiars(final String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(countPeculiarStrings("daata"));
    }
}
