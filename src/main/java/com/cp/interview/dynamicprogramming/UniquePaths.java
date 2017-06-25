package com.cp.interview.dynamicprogramming;

/**
 * Created by curry on 6/18/17.
 */
/*
https://leetcode.com/problems/unique-paths/#/description
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths (3, 7));
    }
}
