package com.song.leetcode;

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 */
public class MergeArray {

    public static void main(String[] args) {
        merge(new int[]{}, 0, new int[]{}, 0);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int j = 0;
        int k = 0;
        int l = 0;
        while (j < m && k < n) {
            if (nums1[j] <= nums2[k]) {
                result[l] = nums1[j];
                j++;
            } else {
                result[l] = nums2[k];
                k++;
            }
            l++;
        }
        while (j < m) {
            result[l] = nums1[j];
            l++;
            j++;
        }
        while (k < n) {
            result[l] = nums2[k];
            l++;
            k++;
        }
        if (result.length >= 0) System.arraycopy(result, 0, nums1, 0, result.length);
        System.out.println(Arrays.toString(nums1));
    }

}
