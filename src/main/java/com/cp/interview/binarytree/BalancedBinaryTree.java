package com.cp.interview.binarytree;

/**
 * Created by curry on 5/9/17.
 */
public class BalancedBinaryTree {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1)
            return false;

        return true;
    }
    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode leftleft = new TreeNode(1);
        TreeNode leftleftleft = new TreeNode(1);
        root.left = left;
        root.right = right;
        left.left = leftleft;
        leftleft.left = leftleftleft;
        System.out.println(isBalanced(root));
    }
}
