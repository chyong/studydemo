package com.song.leetcode;

/**
 * 69.x的平方根
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(10));
    }

    public static int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                r = (int) mid - 1;
            } else {
                l = (int) mid + 1;
            }
        }
        return r;
    }
}
