package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120.三角形最小路径和
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2,3));
        triangle.add(Arrays.asList(1,-1,-3));
//        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int res = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {

            }
        }
        return res;
    }
}
