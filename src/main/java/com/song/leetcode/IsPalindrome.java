package com.song.leetcode;

/**
 * 9.回文数
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int rev = 0;
        int n = x;
        int pop;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10) return false;
            if (rev < Integer.MIN_VALUE / 10) return false;
            rev = rev * 10 + pop;
        }
        return rev == n;
    }
}
