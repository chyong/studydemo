package com.song.leetcode;

import java.util.Arrays;

/**
 * 26.删除排序数组中的重复项
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,3,5,5,6}));
    }

    public static int removeDuplicates(int[] nums) {
        int newLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                newLength++;
                nums[newLength] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length == 0 ? newLength : newLength + 1;
    }

}
