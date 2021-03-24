package com.song.leetcode;

import java.util.Arrays;

/**
 * 剑指 Offer 59 - I.滑动窗口的最大值
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        int j = 0;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i + (k - 1) > nums.length - 1) {
                break;
            }
            res[j++] = findMaxValue(nums, i, i + (k - 1));
        }
        return res;
    }

    public static int findMaxValue(int[] s, int i, int j) {
        int temp = s[i];
        for (int k = i; k <= j; k++) {
            if (temp < s[k]) {
                temp = s[k];
            }
        }
        return temp;
    }
}
