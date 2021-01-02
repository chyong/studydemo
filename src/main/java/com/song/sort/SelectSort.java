package com.song.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
//        int[] array = {101, 34, 119, 1, -1, 90, 123};
        //创建80000个随机数的数组
        int[] array = new int[8000];
        for (int i = 0; i < 8000; i++) {
            array[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        selectSort(array);
        long end = System.currentTimeMillis();
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
        System.out.println("总耗时：" + (end - start) + "ms");
    }

    public static void selectSort(int[] array) {
        //举例：第一次排序，将数组中最小的元素与第一个元素交换位置
        //假设第一个元素最小
//        int min = array[0];
//        int minIndex = 0;
//        for (int i = 0 + 1; i < array.length; i++) {
//            if (min > array[i]) {
//                min = array[i];
//                minIndex = i;
//            }
//        }
//        if (minIndex != 0) {
//            array[minIndex] = array[0];
//            array[0] = min;
//        }
        for (int j = 0; j < array.length - 1; j++) {
            int min = array[j];
            int minIndex = j;
            for (int i = j + 1; i < array.length; i++) {
                if (min > array[i]) {
                    min = array[i];
                    minIndex = i;
                }
            }
            if (minIndex != j) {
                array[minIndex] = array[j];
                array[j] = min;
            }
        }
    }

}
