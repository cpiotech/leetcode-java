package com.cp.interview.binarysearch;

/**
 * Created by curry on 9/19/17.
 */
public class Searcha2DMatrix {
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / n;
            int midY = mid % n;

            if (matrix[midX][midY] == target)
                return true;

            if (matrix[midX][midY] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11}};
        System.out.println(searchMatrix(nums, 3));
    }
}
