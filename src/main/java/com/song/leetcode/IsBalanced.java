package com.song.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 110.平衡二叉树
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                int l = 0;
//                int r = 0;
//                if (node.left != null) {
//                    l = maxDepth(node.left);
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    r = maxDepth(node.right);
//                    queue.add(node.right);
//                }
//                if (Math.abs(r - l) > 1) {
//                    return false;
//                }
//            }
//        }
//        return true;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
