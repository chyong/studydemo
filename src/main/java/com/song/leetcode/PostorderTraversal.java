package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145.二叉树的后序遍历
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node1 = new TreeNode(2, node2, null);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        postOrder(root,list);
        return list;
    }

    public static void postOrder(TreeNode node, List<Integer> list){
        //遍历左子树
        if(node.left!=null){
            postOrder(node.left,list);
        }
        //遍历右子树
        if(node.right!=null){
            postOrder(node.right,list);
        }
        list.add(node.val);
    }
}
