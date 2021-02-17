package com.song.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 118.杨辉三角
 */
public class Generate {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    //动态规划
//    public static List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (numRows == 0) //初始化判断
//            return res;
//        Integer[][] dp = new Integer[numRows + 1][numRows + 1];
//        dp[0][0] = 1;  //初始化
//        res.add(Collections.singletonList(1));
//        for (int i = 1; i < numRows; i++) {
//            dp[i][0] = dp[i][i] = 1;
//            List<Integer> curr = new ArrayList<>();
//            curr.add(1);
//            for (int j = 1; j < i; j++) {
//                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//                curr.add(dp[i][j]);
//            }
//            curr.add(1);
//            res.add(curr);
//        }
//        return res;
//    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
