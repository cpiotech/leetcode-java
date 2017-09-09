package com.cp.interview.dynamicprogramming;

import java.io.Console;

/**
 * Created by curry on 9/3/17.
 */
/*
https://www.careercup.com/question?id=5067634432278528
Given MxN binary matrix, find the largest sub-square matrix with all 1’s.
 */
public class LargestSubSquareWith1 {
    public static int findMaxSubSquareMatrix(int[][] arr) {

        if (arr.length == 0 || arr[0].length == 0) {
            return -1;
        }

        int[][] map = new int[arr.length][arr[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = -1;
            }
        }
        doFindMaxSubSquareMatrix(arr, 0, 0, map);
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        return max;
    }

    private static int doFindMaxSubSquareMatrix(int[][] arr, int i, int j, int[][] map) {
        if (i >= arr.length || j >= arr[0].length) {
            // out of bounds
            return 0;
        }

        if (map[i][j] != -1) {
            // already visited
            return map[i][j];
        }

        int right = doFindMaxSubSquareMatrix(arr, i + 1, j, map);
        int down = doFindMaxSubSquareMatrix(arr, i, j + 1, map);
        int diagonalDown = doFindMaxSubSquareMatrix(arr, i + 1, j + 1, map);
        int subSquareSize = (right == down && right == diagonalDown) ? right : Math.min(right, Math.min(down, diagonalDown));
        int result = arr[i][j] == 1 ? 1 + subSquareSize : subSquareSize;
        map[i][j] = result;
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
        {
            { 1, 1, 0, 0 },
            { 0, 1, 1, 0 },
            { 0, 1, 1, 0 },
            { 1, 0, 0, 0 }
        };

        System.out.println(findMaxSubSquareMatrix(matrix));

        matrix = new int[][]
                {
                        { 1, 1, 0, 0 },
                        { 0, 1, 1, 0 },
                        { 0, 0, 1, 0 },
                        { 1, 0, 0, 0 }
                };

        System.out.println(findMaxSubSquareMatrix(matrix));

        matrix = new int[][]
                {
                        { 1, 1, 0, 0 },
                        { 0, 1, 1, 1 },
                        { 0, 1, 1, 1 },
                        { 1, 0, 1, 1 }
                };
        System.out.println(findMaxSubSquareMatrix(matrix));

        matrix = new int[][]
                {
                        { 1, 1, 0, 0, 1 },
                        { 0, 1, 1, 1, 1 },
                        { 0, 1, 1, 1, 1 },
                        { 1, 0, 1, 1, 1 }
                };
        System.out.println(findMaxSubSquareMatrix(matrix));
    }
}