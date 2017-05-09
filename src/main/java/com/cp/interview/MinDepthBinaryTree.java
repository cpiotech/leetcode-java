package com.cp.interview;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by curry on 5/5/17.
 */
/*
https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description
 */
public class MinDepthBinaryTree {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static class TreeObject {
        TreeNode node;
        int depth;
        TreeObject(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeObject> s = new LinkedList<>();
        int depth = 1;
        s.push(new TreeObject(root, depth));
        int min = Integer.MAX_VALUE;
        while (!s.isEmpty()) {
            TreeObject object = s.remove();
            if (object.node.left == null && object.node.right == null) {
                min = object.depth < min? object.depth : min;
            }
            depth = object.depth+1;
            if (object.node.left != null) {
                s.push(new TreeObject(object.node.left, depth));
            }
            if (object.node.right != null) {
                s.push(new TreeObject(object.node.right, depth));
            }
        }
        return min;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode second = new TreeNode(5);

        root.left = left;
        root.right = right;
        right.right = second;
        int r = minDepth(root);
        System.out.println(r);
    }
}
