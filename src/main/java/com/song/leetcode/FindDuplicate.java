package com.song.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 287.寻找重复数
 */
public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return x;
            }
        }
        return 0;
    }
}
