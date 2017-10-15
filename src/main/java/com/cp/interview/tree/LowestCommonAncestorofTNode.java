package com.cp.interview.tree;

import apple.laf.JRSUIUtils;
import com.cp.interview.binarytree.LowestCommonAncestorofBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by curry on 9/23/17.
 */
public class LowestCommonAncestorofTNode {
    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode parent = null;

        TreeNode(int x) {
            val = x;
        }
    }
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return null;
        }
        if (p == q) {
            return p;
        }
        List<TreeNode> pathOfP = getPath(root, p);
        List<TreeNode> pathOfQ = getPath(root, q);

        if (pathOfP == null || pathOfQ == null) {
            return null;
        }

        int shorterHeight = Math.min(pathOfP.size(), pathOfQ.size());
        for (int i = 0; i < shorterHeight; i++) {
            if (pathOfP.get(pathOfP.size()-1-i) != pathOfQ.get(pathOfQ.size()-1-i)) {
                return pathOfP.get(i+1);
            }
        }

        return pathOfP.get(pathOfP.size()-shorterHeight);
    }

    private static List<TreeNode> getPath(TreeNode root, TreeNode node) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode parent = node;
        while (parent != null) {
            path.add(parent);
            parent = parent.parent;
        }
        if (path.get(path.size()-1) != root) {
            return null;
        }
        return path;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode a = new TreeNode(1);
        a.parent = root;
        TreeNode b = new TreeNode(2);
        b.parent = a;
        TreeNode c = new TreeNode(3);
        c.parent = b;
        TreeNode d = new TreeNode(4);
        d.parent = c;
        TreeNode e = new TreeNode(5);
        e.parent = d;

        System.out.println(lowestCommonAncestor(root, e , a).val);
    }
}
