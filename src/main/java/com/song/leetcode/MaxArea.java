package com.song.leetcode;

/**
 * 11.盛最多水的容器
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

//    public static int maxArea(int[] height) {
//        int n = height.length;
//        int res = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (j + i >= n) break;
//                int s = sum(height, j, j + i);
//                if (s > res) {
//                    res = s;
//                }
//            }
//        }
//        return res;
//    }
//
//    public static int sum(int[] nums, int l, int r) {
//        return Math.min(nums[l], nums[r]) * (r - l);
//    }

    /**
     * 双指针法
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int r = height.length - 1;
        int l = 0;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }

}
