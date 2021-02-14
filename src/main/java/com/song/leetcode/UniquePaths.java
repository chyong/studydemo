package com.song.leetcode;

/**
 * 62.不同路径
 */
public class UniquePaths {
//    static int count = 0;

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    //递归超时
//    public static int uniquePaths(int m, int n) {
//        searPath(0, 0, m, n);
//        return count;
//    }
//
//    public static void searPath(int l, int r, int m, int n) {
//        if (l == m - 1 && r == n - 1) {
//            count++;
//        }
//        if (l < m - 1) {
//            searPath(l + 1, r, m, n);
//        }
//        if (r < n - 1) {
//            searPath(l, r + 1, m, n);
//        }
//    }

    //组合数
//    public static int uniquePaths(int m, int n) {
//        long ans = 1;
//        for (int x = n, y = 1; y < m; ++x, ++y) {
//            ans = ans * x / y;
//        }
//        return (int) ans;
//    }

    //动态规划
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            //左边界赋值
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            //上边界赋值
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
