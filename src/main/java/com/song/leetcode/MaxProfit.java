package com.song.leetcode;

/**
 * 122.买卖股票的最佳时机II
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 4, 6}));
    }

//    public static int maxProfit(int[] prices) {
//        int profit = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            if (prices[i + 1] > prices[i]) {
//                profit = profit + (prices[i + 1] - prices[i]);
//            }
//        }
//        return profit;
//    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
