package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());
//        for (int num : nums) {
//            int all = res.size();
//            for (int j = 0; j < all; j++) {
//                List<Integer> tmp = new ArrayList<>(res.get(j));
//                tmp.add(num);
//                res.add(tmp);
//            }
//        }
//        return res;
//    }

    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, t, ans);
        return ans;
    }

    public static void dfs(int cur, int[] nums, List<Integer> t, List<List<Integer>> ans) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums, t, ans);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums, t, ans);
    }

}
