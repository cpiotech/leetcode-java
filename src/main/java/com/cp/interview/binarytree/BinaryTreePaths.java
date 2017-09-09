package com.cp.interview.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by curry on 9/9/17.
 */
/*
https://leetcode.com/problems/binary-tree-paths/description/
A typical depth-first search problem.
 */
public class BinaryTreePaths {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> finalResult = new ArrayList<>();

        if (root == null)
            return finalResult;

        ArrayList<String> curr = new ArrayList<>();
        ArrayList<ArrayList<String>> results = new ArrayList<>();

        dfs(root, results, curr);

        results.forEach(al -> finalResult.add(String.join("->", al)));
        return finalResult;
    }

    static void dfs(TreeNode root, ArrayList<ArrayList<String>> list, ArrayList<String> curr) {
        curr.add(String.valueOf(root.val));

        if (root.left == null && root.right == null) {
            list.add(curr);
            return;
        }

        if (root.left != null) {
            ArrayList<String> temp = new ArrayList<>(curr);
            dfs(root.left, list, temp);
        }

        if (root.right != null) {
            ArrayList<String> temp = new ArrayList<>(curr);
            dfs(root.right, list, temp);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode leftleft = new TreeNode(5);
        TreeNode leftleftleft = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = leftleft;
        leftleft.left = leftleftleft;
        System.out.println(Arrays.toString(binaryTreePaths(root).toArray()));
    }
}
