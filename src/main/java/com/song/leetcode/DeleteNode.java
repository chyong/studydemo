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

    }

    public static void findVal(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            return;
        }
        if (node.val > val) {
            findVal(node.left, val);
        }
        findVal(node.right, val);
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
