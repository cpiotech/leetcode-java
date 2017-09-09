package com.cp.interview.dynamicprogramming;

/**
 * Created by curry on 6/17/17.
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
    public static void main(String[] args) {
        int[][] nums = {{0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11}};
        //int[][] nums = {};
        System.out.println(minPathSum(nums));
    }
}
