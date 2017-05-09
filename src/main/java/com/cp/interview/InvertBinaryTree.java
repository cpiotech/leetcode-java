package com.cp.interview;

/**
 * Created by curry on 5/3/17.
 */
/*
https://leetcode.com/problems/invert-binary-tree/#/description
 */
public class InvertBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root!=null) {
            invert(root);
        }
        return root;
    }

    private static void invert(TreeNode p) {
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        if(p.left!=null)
            invert(p.left);

        if(p.right!=null)
            invert(p.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode p = invertTree(root);
        System.out.println(p);
    }
}
