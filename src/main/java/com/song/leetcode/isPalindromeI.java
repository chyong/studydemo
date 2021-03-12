package com.song.leetcode;

/**
 * 125.验证回文串
 */
public class isPalindromeI {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
//        StringBuilder sgood = new StringBuilder();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//            if (Character.isLetterOrDigit(ch)) {
//                sgood.append(Character.toLowerCase(ch));
//            }
//        }
//        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
//        return sgood.toString().equals(sgood_rev.toString());

        s = s.toLowerCase();
        char[] c = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!((c[i] >= '0' && c[i] <= '9') || (c[i] >= 'a' && c[i] <= 'z'))) {
                i++;
                continue;
            }
            if (!((c[j] >= '0' && c[j] <= '9') || (c[j] >= 'a' && c[j] <= 'z'))) {
                j--;
                continue;
            }
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
