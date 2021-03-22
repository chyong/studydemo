package com.song.leetcode;

/**
 * 222.完全二叉树的节点个数
 */
public class CountNodes {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(countNodes(node1));
    }

    public static int countNodes(TreeNode root) {
        //递归求解
        if (root == null) return 0;
//        return 1 + countNodes(root.left) + countNodes(root.right);
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private static int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
