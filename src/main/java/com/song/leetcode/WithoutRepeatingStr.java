package com.song.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3.无重复字符的最长子串
 */
public class WithoutRepeatingStr {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("anagram"));
    }

    public static int lengthOfLongestSubstring1(String s) {
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

    public static int lengthOfLongestSubstring2(String s) {
        //滑动窗口
        int n = s.length();
        int res = 0, start = 0;
        Set<Character> occ = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (start < n && !occ.contains(s.charAt(start))) {
                occ.add(s.charAt(start));
                start++;
            }
            res = Math.max(res, start - i);
        }
        return res;
    }

}
