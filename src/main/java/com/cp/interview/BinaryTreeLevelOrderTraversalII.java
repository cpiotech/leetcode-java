package com.cp.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by curry on 5/7/17.
 */
/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
 */
public class BinaryTreeLevelOrderTraversalII {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static  List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> st = new Stack<>();
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();
        if (root == null)
            return al;

        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        current.add(root);

        while (!current.isEmpty()) {
            TreeNode node = current.remove();

            if (node.left != null)
                next.add(node.left);
            if (node.right != null)
                next.add(node.right);

            nodeValues.add(node.val);
            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                st.add(nodeValues);
                nodeValues = new ArrayList();
            }

        }
        while (!st.isEmpty()) {
            al.add(st.pop());
        }
        return al;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        List<List<Integer>> r = levelOrderBottom(root);
        System.out.println(r);
    }
}
