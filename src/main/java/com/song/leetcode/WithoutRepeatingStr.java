package com.song.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WithoutRepeatingStr {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("anagram"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int end = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (; start < n && end < n; end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);//从有重复的下一个位置继续找
            }
            map.put(s.charAt(end), end + 1);//map每次更新
            res = Math.max(res, end - start + 1);//结果每次更新
        }
        return res;
    }

}
