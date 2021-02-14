package com.song.leetcode;

/**
 * 48.旋转图像
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix.length; i1++) {
                matrix[i][i1] = count++;
            }
        }
        for (int[] ints : matrix) {
            for (int i1 = 0; i1 < matrix.length; i1++) {
                System.out.print(ints[i1] + " ");
            }
            System.out.println();
        }
        System.out.println();
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int i1 = 0; i1 < matrix.length; i1++) {
                System.out.print(ints[i1] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //暴力解法，新建一个数组
//        int[][] matrix_new = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int i1 = 0; i1 < n; i1++) {
//                matrix_new[i][i1] = matrix[n - 1 - i1][i];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            System.arraycopy(matrix_new[i], 0, matrix[i], 0, n);
//        }
        //原地反转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
