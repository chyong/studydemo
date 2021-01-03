package com.song.sort;

import java.util.Arrays;

public class ShellSort {

    //希尔排序
    public static void main(String[] args) {
//        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //创建80000个随机数的数组
        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
//        swapSort(array);
        moveSort(array);
        long end = System.currentTimeMillis();
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
        System.out.println("总耗时：" + (end - start) + "ms");

    }

    public static void swapSort(int[] array) {
        int temp = 0;
        //交换法，性能差
//        //第1轮，分成10/2=5组，两个元素一组
//        for (int i = 5; i < array.length; i++) {
//            for (int j = i - 5; j >= 0; j -= 5) {
//                if (array[j] > array[j + 5]) {
//                    temp = array[j];
//                    array[j] = array[j + 5];
//                    array[j + 5] = temp;
//                }
//            }
//        }
//        //第2轮，分成5/2=2组，五个元素一组
//        for (int i = 2; i < array.length; i++) {
//            for (int j = i - 2; j >= 0; j -= 2) {
//                if (array[j] > array[j + 2]) {
//                    temp = array[j];
//                    array[j] = array[j + 2];
//                    array[j + 2] = temp;
//                }
//            }
//        }
//        //第3轮，先分成2/2=1组，十个元素一组
//        for (int i = 1; i < array.length; i++) {
//            for (int j = i - 1; j >= 0; j -= 1) {
//                if (array[j] > array[j + 1]) {
//                    temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }
        //推广
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }

    }

    public static void moveSort(int[] array) {
        int temp = 0;
        //移位法，增量gap，并逐步的缩小增量
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < array.length; i++) {
                int j = i;
                temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        //移动
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    array[j] = temp;
                }
            }
        }

    }

}
