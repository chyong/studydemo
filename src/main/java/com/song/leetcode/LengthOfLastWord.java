package com.song.leetcode;

/**
 * 58.最后一个单词的长度
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   "));
    }

    public static int lengthOfLastWord(String s) {
//        s = s.trim();
//        if ("".equals(s)) return 0;
//        String[] res = s.split(" ");
//        return res[res.length - 1].length();
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }
}
