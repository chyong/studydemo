package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144.二叉树的前序遍历
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node1 = new TreeNode(2, node2, null);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        preOrder(root, list);
        return list;
    }

    public static void preOrder(TreeNode root, List<Integer> list) {
        list.add(root.val);
        //递归查找左子树
        if (root.left != null) {
            preOrder(root.left, list);
        }
        //递归查找右子树
        if (root.right != null) {
            preOrder(root.right, list);
        }
    }
}
