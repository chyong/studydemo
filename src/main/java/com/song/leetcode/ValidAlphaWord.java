package com.song.leetcode;

import java.util.Arrays;

/**
 * 242.有效的字母异位词
 */
public class ValidAlphaWord {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i])
                return false;
        }

        return true;
    }
}
