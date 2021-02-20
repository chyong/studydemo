package com.song.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 136.只出现一次的数字
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public static int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.get(num) == null) {
//                map.put(num, num);
//            } else {
//                map.remove(num);
//            }
//        }
//        return map.values().iterator().next();
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
