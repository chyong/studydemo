package com.song.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixExpressionConvert {

    public static void main(String[] args) {
        //后缀表达式转中缀表达式
        Stack<String> stack = new Stack<>();
        List<String> postfixExpressionList = new ArrayList<>();
        List<String> expressionList = getExpressionList("1+((2+3)*4)-5");
        for (String s : expressionList) {
            if (isOperator(s)) {
                //运算符
                if ("(".equals(s)) {
                    stack.push(s);
                } else if (")".equals(s)) {
                    while (!"(".equals(stack.peek())) {
                        postfixExpressionList.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && getOperaPrior(s) <= getOperaPrior(stack.peek())) {
                        postfixExpressionList.add(stack.pop());
                    }
                    stack.push(s);
                }
            } else {
                //操作数
                postfixExpressionList.add(s);
            }
        }
        while (!stack.isEmpty()) {
            postfixExpressionList.add(stack.pop());
        }
        postfixExpressionList.forEach(x -> System.out.print(x + " "));
    }

    public static List<String> getExpressionList(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                //非数字
                list.add(String.valueOf(s.charAt(i)));
                i++;
            } else {
                //数字，考虑多位数
                while (i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    str.append(s.charAt(i));
                    i++;
                }
                list.add(str.toString());
                str = new StringBuilder();
            }
        }
        return list;
    }

    public static boolean isOperator(String a) {
        List<String> ls = new ArrayList<>();
        ls.add("+");
        ls.add("-");
        ls.add("*");
        ls.add("/");
        ls.add("(");
        ls.add(")");
        return ls.contains(a);
    }

    public static int getOperaPrior(String s) {
        if (s.equals("+") || s.equals("-")) {
            return 1;
        } else if (s.equals("*") || s.equals("/")) {
            return 2;
        }
        return 0;
    }

}
