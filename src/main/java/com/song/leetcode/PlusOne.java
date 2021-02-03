package com.song.leetcode;

import java.util.Arrays;

/**
 * 66.加一
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 3, 2, 9, 9, 9, 9, 9, 9, 1, 4, 6, 7, 8, 8, 9, 9, 5, 8, 9, 3, 9})));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

}
