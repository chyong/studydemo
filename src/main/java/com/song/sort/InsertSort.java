package com.song.sort;

import java.util.Arrays;

public class InsertSort {
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
        insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
        System.out.println("总耗时：" + (end - start) + "ms");
    }

    public static void insertSort(int[] array) {
        //举例：第一次排序，将数组中归为无序集合的第二个元素插入到第一个元素所在的有序集合中
        //取第二个元素
//        int insertValue = array[1];
//        int insertIndex = 1 - 1;
//        while (insertIndex >= 0 && array[insertIndex + 1] < array[insertIndex]) {
//            array[insertIndex + 1] = array[insertIndex];
//            insertIndex--;
//        }
//        array[insertIndex + 1] = insertValue;

        for (int j = 1; j < array.length; j++) {
            int insertValue = array[j];
            int insertIndex = j - 1;
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex + 1] = insertValue;
        }
    }
}
