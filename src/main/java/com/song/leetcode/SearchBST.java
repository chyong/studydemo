package com.song.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 700.二叉搜索树中的搜索
 */
public class SearchBST {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(inorderTraversal(searchBST(root, 0)));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for (int i = 0; i <size; i++) {
//                TreeNode node = queue.poll();
//                if(val == node.val) return node;
//                if(node.left != null){
//                    queue.add(node.left);
//                }
//                if(node.right != null){
//                    queue.add(node.right);
//                }
//            }
//        }
//        return null;
        return findVal(root, val);
    }

    public static TreeNode findVal(TreeNode node, int val) {
        if(node == null){
            return null;
        }
        if(node.val==val){
            return node;
        }
        if(node.val > val){
            return findVal(node.left, val);
        }
        return findVal(node.right, val);
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
