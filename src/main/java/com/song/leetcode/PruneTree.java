package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 814.二叉树剪枝
 */
public class PruneTree {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1, node2, node3);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(inorderTraversal(pruneTree(root)));
    }

    public static TreeNode pruneTree(TreeNode root) {
        return deal(root);
    }

    public static TreeNode deal(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = deal(node.left);
        node.right = deal(node.right);
        if (node.left == null && node.right == null && node.val == 0) {
            return null;
        }
        return node;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        infixOrder(root, list);
        return list;
    }

    public static void infixOrder(TreeNode root, List<Integer> list) {
        //递归查找左子树
        if (root.left != null) {
            infixOrder(root.left, list);
        }
        list.add(root.val);
        //递归查找右子树
        if (root.right != null) {
            infixOrder(root.right, list);
        }
    }
}
