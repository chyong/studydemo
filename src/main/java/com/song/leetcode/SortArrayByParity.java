package com.song.leetcode;

import java.util.Arrays;

/**
 * 905.按奇偶排序数组
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;
        for (int j : A)
            if (j % 2 == 0)
                ans[t++] = j;
        for (int j : A)
            if (j % 2 == 1)
                ans[t++] = j;
        return ans;
    }
}
