package com.song.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 64.最小路径和
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[4][1];
        Stack<Integer> stack = new Stack<>();
//        stack.addAll(Arrays.asList(1, 2, 4, 1, 5, 1, 1, 3, 1));
//        stack.addAll(Arrays.asList(6, 5, 4, 3, 2, 1));
        stack.addAll(Arrays.asList(8, 4, 1, 9));
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[0].length; i1++) {
                grid[i][i1] = stack.pop();
            }
        }
        for (int[] ints : grid) {
            for (int i1 = 0; i1 < grid[0].length; i1++) {
                System.out.print(ints[i1] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
