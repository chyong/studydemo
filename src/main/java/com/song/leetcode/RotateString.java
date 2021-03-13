package com.song.leetcode;

/**
 * 796.旋转字符串
 */
public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }

    public static boolean rotateString(String A, String B) {
//        if ("".equals(A) && "".equals(B)) {
//            return true;
//        }
//        char[] chars = A.toCharArray();
//        int n = chars.length;
//        char temp;
//        for (int j = 0; j < A.length(); j++) {
//            for (int i = n - 1; i > 0; i--) {
//                temp = chars[i];
//                chars[i] = chars[i - 1];
//                chars[i - 1] = temp;
//            }
//            if (B.equals(getString(chars))) return true;
//        }
//        return false;
        return A.length() == B.length() && (A + A).contains(B);
    }

    public static String getString(char[] chars) {
        StringBuilder res = new StringBuilder();
        for (char aChar : chars) {
            res.append(aChar);
        }
        return res.toString();
    }
}
