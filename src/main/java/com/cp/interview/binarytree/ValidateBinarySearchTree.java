package com.cp.interview.binarytree;

import java.util.Arrays;

/**
 * Created by curry on 5/2/17.
 */
/*
https://leetcode.com/problems/validate-binary-search-tree/#/description
 */
public class ValidateBinarySearchTree {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    private static boolean isValid(TreeNode root, double minValue, double maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        //TreeNode left = new TreeNode(1);
        //TreeNode right = new TreeNode(3);
        //root.left = left;
        //root.right = right;
        System.out.println(isValidBST(root));
    }
}
