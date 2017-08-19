package com.cp.interview.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by curry on 6/18/17.
 */
public class CoinChange2 {
    public static int change(int amount, int[] coins) {

        long[] table = new long[amount+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i< coins.length; i++) {
            for (int j=coins[i]; j<=amount; j++) {
                table[j] += table[j-coins[i]];
            }
            System.out.println(Arrays.toString(table));
        }
        return (int)table[amount];
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(change(5, nums));
    }
}
