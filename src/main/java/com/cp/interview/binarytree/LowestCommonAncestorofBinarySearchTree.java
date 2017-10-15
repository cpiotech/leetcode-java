package com.cp.interview.binarytree;

/**
 * Created by curry on 9/11/17.
 */
public class LowestCommonAncestorofBinarySearchTree {
    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val < q.val){
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(8);
        TreeNode leftleft = new TreeNode(2);
        TreeNode leftleftleft = new TreeNode(1);
        root.left = left;
        //root.right = right;
        //left.left = leftleft;
        //leftleft.left = leftleftleft;
        System.out.println(lowestCommonAncestor(root, left, root).val);
    }
}
