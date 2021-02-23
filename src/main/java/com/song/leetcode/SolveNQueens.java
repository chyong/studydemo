package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51.N皇后
 */
public class SolveNQueens {

    static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        int[] array = new int[n];
        setQueens(0, n, array);
        return list;
    }

    public static boolean check(int n, int[] array) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //n为第一个皇后放置的位置，比如第一行第n+1列
    public static void setQueens(int k, int n, int[] array) {
        if (k == n) {
            //所有皇后均已放置完毕
            print(n, array);
            return;
        }
        //依次放入皇后
        for (int i = 0; i < n; i++) {
            array[k] = i;
            if (check(k, array)) {
                //如果可以放置
                setQueens(k + 1, n, array);
            }
        }
    }

    public static void print(int n, int[] array) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[array[i]] = 'Q';
            strings.add(new String(row));
        }
        list.add(strings);
    }

}
