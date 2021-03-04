package com.song.leetcode;

import java.util.Arrays;

/**
 * 189.旋转数组
 */
public class RotateI {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        int temp;
//        for (int j = 0; j < k; j++) {
//            for (int i = n - 1; i > 0; i--) {
//                temp = nums[i];
//                nums[i] = nums[i - 1];
//                nums[i - 1] = temp;
//            }
//        }
//        int n = nums.length;
//        int[] newArr = new int[n];
//        for (int i = 0; i < n; ++i) {
//            newArr[(i + k) % n] = nums[i];
//        }
//        System.arraycopy(newArr, 0, nums, 0, n);
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
