package com.song.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 387.字符串中的第一个唯一字符
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("lllll"));
    }

    public static int firstUniqChar(String s) {
//        int n = s.length();
//        char[] arr = s.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        Integer temp;
//        for (int i = 0; i < n; i++) {
//            temp = map.get(arr[i]);
//            if (temp != null) {
//                map.put(arr[i], temp + 1);
//            } else {
//                map.put(arr[i], 1);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (map.get(arr[i]) == 1) {
//                return i;
//            }
//        }
//        return -1;
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
