package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98.验证二叉搜索树
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) return true;
//        infixOrder(root, list);
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) <= list.get(i - 1)) {
//                return false;
//            }
//        }
//        return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
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

    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

}
