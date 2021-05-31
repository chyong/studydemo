package com.song.leetcode;

import java.util.Arrays;

/**
 * 16.最接近的三数之和
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int value = nums[i] + nums[start] + nums[end];
                if (value == target) {
                    return value;
                }
                if (Math.abs(value - target) < min) {
                    min = Math.abs(value - target);
                    ans = value;
                }
                if (value > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ans;
    }

}
