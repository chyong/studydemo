package com.song.sort;

import java.util.Arrays;

public class QuickSort {

    //快速排序
    public static void main(String[] args) {
//        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //创建80000个随机数的数组
        int[] array = new int[2000];
        for (int i = 0; i < 2000; i++) {
            array[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
        System.out.println("总耗时：" + (end - start) + "ms");

    }

//    public static void quickSort(int[] array, int left, int right) {
//        int l = left;//左下标
//        int r = right;//右下标
//        int temp = 0;
//        //pivot中轴值
//        int pivot = array[(left + right) / 2];
//        //while循环的目的是让比pivot值小的放到左边，比pivot大的放到右边
//        while (l < r) {
//            //在pivot的左边一直找，找到大于等于pivot值，才退出
//            while (array[l] < pivot) {
//                l += 1;
//            }
//            //在pivot的右边一直找，找到小于等于pivot值，才退出
//            while (array[r] > pivot) {
//                r -= 1;
//            }
//            //如果l >= r说明pivot的左右两边的值，已经按照左边全部是小于等于pivot的值，右边全部是大于等于pivot的值
//            if (l >= r) {
//                break;
//            }
//            //交换
//            temp = array[l];
//            array[l] = array[r];
//            array[r] = temp;
//            //如果交换完后，发现array[l]==pivot，r--，前移
//            if (array[l] == pivot) {
//                r -= 1;
//            }
//            //如果交换完后，发现array[r]==pivot，l++，后移
//            if (array[r] == pivot) {
//                l += 1;
//            }
//            //如果l==r，必须l++，r--，否则会出现栈溢出
//            if (l == r) {
//                l += 1;
//                r -= 1;
//            }
//            //向左递归
//            if (left < r) {
//                quickSort(array, left, r);
//            }
//            //向右递归
//            if (right > l) {
//                quickSort(array, l, right);
//            }
//        }
//    }

    public static void quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) quickSort(arr, start, i - 1);
        if (j + 1 < end) quickSort(arr, j + 1, end);
    }

}
