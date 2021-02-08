package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 */
public class Permute {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res);
        return res;
    }

    /**
     * 深度优先搜索算法（回溯）
     *
     * @param nums
     * @param tmp
     * @param res
     */
    public static void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int num : nums) {
                if (!tmp.contains(num)) {
                    tmp.add(num);
                    dfs(nums, tmp, res);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

}
