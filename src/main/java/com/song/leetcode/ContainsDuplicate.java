package com.song.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 217.存在重复元素
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}
