package com.song.leetcode;

/**
 * 53.最大子序和
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, 2}));
    }

    //滑动窗口法，时间复杂度不满足题目要求
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int sum = nums[0];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (j + i > n) break;
//                int s = sum(nums, j, j + i);
//                if (s > sum) {
//                    sum = s;
//                }
//            }
//        }
//        return sum;
//    }
//
//    public static int sum(int[] nums, int l, int r) {
//        int sum = 0;
//        for (int i = l; i < r; i++) {
//            sum = sum + nums[i];
//        }
//        return sum;
//    }

    /**
     * 贪心算法
     * 若当前指针所指元素之前的和小于0，则丢弃当前元素之前的数列
     *
     * @param nums
     * @return
     */
//    public static int maxSubArray(int[] nums) {
//        int res = nums[0];
//        int sum = 0;
//        for (int num : nums) {
//            if (sum < 0) {
//                sum = num;
//            } else {
//                sum = sum + num;
//            }
//            res = Math.max(res, sum);
//        }
//        return res;
//    }


    /**
     * 动态规划
     * 若前一个元素大于0，则将其加到当前元素上
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
//        int res = nums[0];
//        int sum = 0;
//        for (int num : nums) {
//            if (sum > 0) {
//                sum = sum + num;
//            } else {
//                sum = num;
//            }
//            res = Math.max(res, sum);
//        }
//        return res;
        if (nums.length < 1) {
            return 0;
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
