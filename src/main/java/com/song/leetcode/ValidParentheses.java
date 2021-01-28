package com.song.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20.有效的括号
 */
public class ValidParentheses {

    public static void main(String[] args){
        System.out.println(isValid("}}"));
    }

    public static boolean isValid(String s) {
        if(s.length()==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length(); i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(s.charAt(i)==')'){
                    if(stack.pop()!='(') return false;
                }else if(s.charAt(i)=='}'){
                    if(stack.pop()!='{') return false;
                }else if(s.charAt(i)==']'){
                    if(stack.pop()!='[') return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
