package com.song.leetcode;

import java.util.Arrays;

/**
 * 1.两数之和
 */
public class SumOfTwoNum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 3, 3, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    k = 1;
                }
                if (k == 1) {
                    break;
                }
            }
            if (k == 1) {
                break;
            }
        }
        return result;
    }

}
