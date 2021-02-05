package com.song.leetcode;

/**
 * 53.最大子序和
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

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
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
