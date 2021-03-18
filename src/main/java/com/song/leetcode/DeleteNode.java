package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 450.删除二叉搜索树中的节点
 */
public class DeleteNode {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(inorderTraversal(deleteNode(root, 2)));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode newRoot = root.left;
            TreeNode cur = newRoot;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = root.right;
            return newRoot;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
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
