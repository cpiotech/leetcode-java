package com.cp.interview.binarytree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by curry on 9/9/17.
 */
/*
http://articles.leetcode.com/lowest-common-ancestor-of-a-binary-tree-part-i/
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestorofBinaryTree {
    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //发现目标节点则通过返回值标记该子树发现了某个目标结点
//        if (root == null || root == p || root == q)
//            return root;
//        //查看左子树中是否有目标结点，没有为null
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        //查看右子树是否有目标节点，没有为null
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        //都不为空，说明左右子树都有目标结点，则公共祖先就是本身
//        if (left != null && right != null)
//            return root;
//        //如果发现了目标节点，则继续向上标记为该目标节点
//        return left == null ? right : left;
//    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        ArrayList<TreeNode> curr = new ArrayList<>();
        ArrayList<ArrayList<TreeNode>> results = new ArrayList<>();

        dfs(root, results, curr, p);
        curr = new ArrayList<>();
        dfs(root, results, curr, q);

        if (results.size() < 2) {
            return null;
        }
        int count = 0;
        while (count < results.get(0).size() && count < results.get(1).size()
                && results.get(0).get(count) == results.get(1).get(count)) {
               count++;
        }

        return results.get(0).get(count-1);
    }

    static void dfs(TreeNode root, ArrayList<ArrayList<TreeNode>> list, ArrayList<TreeNode> curr, TreeNode dest) {
        curr.add(root);

        if (root == dest) {
            list.add(curr);
            return;
        }

        if (root.left != null) {
            ArrayList<TreeNode> temp = new ArrayList<>(curr);
            dfs(root.left, list, temp, dest);
        }

        if (root.right != null) {
            ArrayList<TreeNode> temp = new ArrayList<>(curr);
            dfs(root.right, list, temp, dest);
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
        System.out.println(lowestCommonAncestor(root, leftleft, leftleftleft).val);
    }
}
