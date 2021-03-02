package com.song.leetcode;

import java.util.*;

/**
 * 350.两个数组的交集II
 */
public class Intersect {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 4, 8, 9,4}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums2) {
            map.merge(k, 1, Integer::sum);
        }
        for (int i : nums1) {
            if (map.get(i) != null && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] num = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            num[i] = list.get(i);
        }
        return num;
    }
}
