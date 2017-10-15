package com.cp.interview.amazonjp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by curry on 9/5/17.
 */
public class TriangularBoxes {
    static long combinations(long t, int[] d) {
        int count = 0;
        if (d == null || d.length < 3 || t == 0) {
            return 0;
        }

        Arrays.sort(d);

        for (int i = 0; i < d.length - 2; i++) {
            int start = i + 1;
            int end = d.length - 1;
            while (start < end) {
                if (d[start] + d[end] + d[i] <= t) {
                    count = count + (end - start);
                    start++;
                } else if (d[start] + d[end] + d[i] > t) {
                    end--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4}; //1234
        System.out.println((combinations(9, nums)));
    }
}
