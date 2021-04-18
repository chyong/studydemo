package com.song.leetcode;

/**
 * 70.爬楼梯
 */
public class ClimbStair {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 动态规划算法解决爬楼梯问题
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        //该方法较废内存
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                dp[i] = i + 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n - 1];
        //优化后的方法
//        if (n <= 2) {
//            return n;
//        }
//        int i1 = 1;
//        int i2 = 2;
//        int temp = 0;
//        for (int i = 3; i <= n; i++) {
//            temp = i1 + i2;
//            i1 = i2;
//            i2 = temp;
//        }
//        return temp;
    }

}
