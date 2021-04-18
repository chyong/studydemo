package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if (nums[i] > 0)
                break;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (l < r) {
                    if (0 == nums[i] + nums[l] + nums[r]) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l + 1] == nums[l]) l++;
                        while (l < r && nums[r - 1] == nums[r]) r--;
                        l++;
                        r--;
                    } else if (0 > nums[i] + nums[l] + nums[r]) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

}
