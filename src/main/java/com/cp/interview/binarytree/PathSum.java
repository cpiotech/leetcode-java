package com.cp.interview.binarytree;

import java.util.LinkedList;

/**
 * Created by curry on 5/10/17.
 */
public class PathSum {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /*
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();

        nodes.add(root);
        values.add(root.val);

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();

            if (curr.left == null && curr.right == null && sumValue == sum) {
                return true;
            }

            if (curr.left != null) {
                nodes.add(curr.left);
                values.add(sumValue + curr.left.val);
            }

            if (curr.right != null) {
                nodes.add(curr.right);
                values.add(sumValue + curr.right.val);
            }
        }

        return false;
    }
    */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum == root.val && root.left == null && root.right ==null) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
        System.out.println(hasPathSum(root, 3));
    }
}
