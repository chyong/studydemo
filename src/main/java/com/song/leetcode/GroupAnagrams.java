package com.song.leetcode;


import java.util.*;

/**
 * 49.字母异位词分组
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = null == map.get(key) ? new ArrayList<>() : map.get(key);
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
