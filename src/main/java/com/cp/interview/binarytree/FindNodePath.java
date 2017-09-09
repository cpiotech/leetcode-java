package com.cp.interview.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by curry on 5/10/17.
 */
public class FindNodePath {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<String> findNodePath(TreeNode root, int dest) {
        ArrayList<String> finalResult = new ArrayList<>();
        if (root == null)
            return finalResult;

        ArrayList<String> curr = new ArrayList<>();
        ArrayList<ArrayList<String>> results = new ArrayList<>();

        dfs(root, results, curr, dest);

        results.forEach(al -> finalResult.add(String.join("->", al)));
        return finalResult;
    }

    static void dfs(TreeNode root, ArrayList<ArrayList<String>> list, ArrayList<String> curr, int dest) {
        curr.add(String.valueOf(root.val));

        if (root.val == dest) {
            list.add(curr);
            return;
        }

        if (root.left != null) {
            ArrayList<String> temp = new ArrayList<>(curr);
            dfs(root.left, list, temp, dest);
        }

        if (root.right != null) {
            ArrayList<String> temp = new ArrayList<>(curr);
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
        System.out.println(Arrays.toString(findNodePath(root, 9).toArray()));
    }
}
