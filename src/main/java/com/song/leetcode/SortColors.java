package com.song.leetcode;

import java.util.Arrays;

/**
 * 75.颜色分类
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 1, 0, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        //单指针法
//        int start = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                int temp = nums[i];
//                nums[i] = nums[start];
//                nums[start] = temp;
//                start++;
//            }
//        }
//        for (int i = start; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                int temp = nums[i];
//                nums[i] = nums[start];
//                nums[start] = temp;
//                start++;
//            }
//        }
        //双指针法
        int i = 0;
        int p0 = 0;
        int p1 = nums.length - 1;
        while (i <= p1) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1--;
            }
        }
    }
}
