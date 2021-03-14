package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 104.二叉树的最大深度
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode node4 = new TreeNode(2, node3, node2);
        TreeNode root = new TreeNode(1, node1, node4);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> depthStack = new Stack<>();
//        stack.push(root);
//        int depth = 1;
//        depthStack.push(depth);
//        while (stack.size() > 0) {
//            TreeNode node = stack.pop();
//            int temp = depthStack.pop();
//            depth = Math.max(temp, depth);
//            if (node.left != null) {
//                stack.push(node.left);
//                depthStack.push(temp + 1);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//                depthStack.push(temp + 1);
//            }
//        }
//        return depth;

//        int res = 0;
//        List<TreeNode> nodes = new ArrayList<>();
//        nodes.add(root);
//        while (!nodes.isEmpty()) {
//            int size = nodes.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode remove = nodes.remove(0);
//                if (remove.left != null) {
//                    nodes.add(remove.left);
//                }
//                if (remove.right != null) {
//                    nodes.add(remove.right);
//                }
//            }
//            res++;
//        }
//        return res;
    }
}
