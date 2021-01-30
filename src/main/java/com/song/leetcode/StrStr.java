package com.song.leetcode;

import java.util.Arrays;

/**
 * 28.实现 strStr()
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("aaaab", "b"));
    }

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle) || needle.equals(haystack)) return 0;
        if (needle.length() > haystack.length()) return -1;
        int gap = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (i + gap > haystack.length()) break;
            if (needle.equals(haystack.substring(i, i + gap))) {
                return i;
            }
        }
        return -1;
    }

}
