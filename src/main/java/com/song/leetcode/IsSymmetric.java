package com.song.leetcode;

/**
 * 101.对称二叉树
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode node4 = new TreeNode(2, node3, node2);
        TreeNode root = new TreeNode(1, node1, node4);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return find(root, root);
    }

    public static boolean find(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && find(left.left, right.right) && find(left.right, right.left);
    }
}
