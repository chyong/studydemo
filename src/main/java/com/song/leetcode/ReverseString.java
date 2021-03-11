package com.song.leetcode;

import java.util.Arrays;

/**
 * 344.反转字符串
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'q', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int n = s.length;
        if (n == 0) return;
        char temp;
        for (int i = 0; i < n / 2; i++) {
            temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
    }
}
