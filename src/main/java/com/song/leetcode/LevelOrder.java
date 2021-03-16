package com.song.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102.二叉树的层序遍历
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> lists = new ArrayList<>();
//        if (root == null) {
//            return lists;
//        }
//        List<TreeNode> nodes = new ArrayList<>();
//        nodes.add(root);
//        while (!nodes.isEmpty()) {
//            int size = nodes.size();
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode remove = nodes.remove(0);
//                list.add(remove.val);
//                if (remove.left != null) {
//                    nodes.add(remove.left);
//                }
//                if (remove.right != null) {
//                    nodes.add(remove.right);
//                }
//            }
//            lists.add(list);
//        }
//        return lists;
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(level);
        }
        return lists;
    }
}
