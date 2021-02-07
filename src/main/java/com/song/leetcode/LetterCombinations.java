package com.song.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.电话号码的字母组合
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Character,Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a','b','c'});
        map.put('3', new Character[]{'d','e','f'});
        map.put('4', new Character[]{'g','h','i'});
        map.put('5', new Character[]{'j','k','l'});
        map.put('6', new Character[]{'m','n','o'});
        map.put('7', new Character[]{'p','q','r','s'});
        map.put('8', new Character[]{'t','u','v'});
        map.put('9', new Character[]{'w','x','y','z'});

        return list;
    }
}
