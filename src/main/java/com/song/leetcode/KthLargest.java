package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指Offer 54.二叉搜索树的第k大节点
 */
public class KthLargest {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(3, node2, null);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(kthLargest(root, 2));
    }

    public static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        infixOrder(root, list);
        return list.get(list.size() - k);
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
