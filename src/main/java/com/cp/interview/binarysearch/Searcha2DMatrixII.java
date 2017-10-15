package com.cp.interview.binarysearch;

/**
 * Created by curry on 9/19/17.
 */
public class Searcha2DMatrixII {
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        int i = m;
        int j = 0;

        while (i >= 0 && j <= n) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 4, 7},
                {4, 5, 8},
                {10, 13, 14}};
        System.out.println(searchMatrix(nums, 13));
    }
}
