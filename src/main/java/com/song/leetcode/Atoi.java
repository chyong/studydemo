package com.song.leetcode;

/**
 * 8.字符串转换整数
 */
public class Atoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("rtyu12"));
    }

    public static int myAtoi(String s) {
//        if (null == s || "".equals(s)) {
//            return 0;
//        }
//        s = s.trim();
//        long res = 0;
//        if (s.length() > 0) {
//            char[] ch = s.toCharArray();
//            if (s.length() == 1) {
//                if (ch[0] < 48 || ch[0] > 57) {
//                    return 0;
//                } else {
//                    return Integer.parseInt(s);
//                }
//            }
//            if (ch[0] < 48 && '-' != ch[0] && '+' != ch[0] || ch[0] > 57 || '-' == ch[0] && ch[1] < 48 && '+' == ch[1] || ch[1] > 57 && '-' == ch[0] && '+' == ch[0]) {
//                return 0;
//            } else {
//                StringBuilder a = new StringBuilder();
//                for (int i = 0; i < s.length(); i++) {
//                    if (i == 0 && ch[i] == '-') {
//                        a.append(ch[i]);
//                    }
//                    if (ch[i] < 48 && '.' != ch[i] || ch[i] > 57 && '.' != ch[i] || '0' == ch[i] || '+' == ch[i]) {
//                        continue;
//                    }
//                    a.append(ch[i]);
//                }
//                if (a.toString().contains(".")) {
//                    a = new StringBuilder(a.toString().split("\\.")[0]);
//                }
//                res = Long.parseLong(a.toString());
//                if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//                if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
//            }
//        }
//        return (int) res;
        s = s.trim();
        if (s.length() == 0) return 0;
        if (!Character.isDigit(s.charAt(0))
                && s.charAt(0) != '-' && s.charAt(0) != '+')
            return 0;
        long ans = 0L;
        boolean neg = s.charAt(0) == '-';
        int i = !Character.isDigit(s.charAt(0)) ? 1 : 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }

}
