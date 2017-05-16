package com.cp.interview.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by curry on 5/4/17.
 */
/*
https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
 */
public class BinaryTreeLevelOrderTraversal {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> al = new ArrayList<>();
//        List<Integer> nodeValues = new ArrayList<>();
//        if(root == null)
//            return al;
//
//        LinkedList<TreeNode> current = new LinkedList<>();
//        current.add(root);
//        int index = 1;
//        while (!current.isEmpty()) {
//            int insideIndex = 0;
//            for (int i = 0; i < index; i++) {
//                TreeNode node = current.remove();
//                if(node.left != null) {
//                    current.add(node.left);
//                    insideIndex++;
//                }
//                if(node.right != null) {
//                    current.add(node.right);
//                    insideIndex++;
//                }
//
//                nodeValues.add(node.val);
//
//            }
//            index = insideIndex;
//            al.add(nodeValues);
//            nodeValues = new ArrayList();
//        }
//        return al;
//    }
    public static  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();
        if (root == null)
            return al;

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
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
                next = new LinkedList<TreeNode>();
                al.add(nodeValues);
                nodeValues = new ArrayList();
            }

        }
        return al;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        List<List<Integer>> r = levelOrder(root);
        System.out.println(r);
    }
}
