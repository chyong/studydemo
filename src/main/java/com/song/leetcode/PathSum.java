package com.song.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113.路径总和II
 */
public class PathSum {
    static List<List<Integer>> ret = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, node2, node3);
        TreeNode node4 = new TreeNode(5, node3, node2);
        TreeNode root = new TreeNode(1, node1, node4);
        System.out.println(pathSum(root, 7));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<>(list));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        list.remove(list.size() - 1);
    }
}
