package com.cp.interview.dynamicprogramming;

/**
 * Created by curry on 6/18/17.
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
