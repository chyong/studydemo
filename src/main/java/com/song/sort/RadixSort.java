package com.song.sort;

import java.util.Arrays;

public class RadixSort {

    //基数排序
    public static void main(String[] args) {
//        int[] array = {8, 96, 15, 37, 2, 309, 5, 4, 61, 0};
        //创建80000个随机数的数组
        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        radixSort(array);
        long end = System.currentTimeMillis();
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
        System.out.println("总耗时：" + (end - start) + "ms");
    }

    public static void radixSort(int[] array) {
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //说明
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定为array.length
        //3.基数排序是空间换时间的经典算法
        int[][] bucket = new int[10][array.length];
        //为了记录每个桶中，实际放了多少个数据，我们定义一个一位数组来记录各个桶的每次放入的数据个数
        //比如：bucketElementCounts[0]记录的就是bucket[0]桶中放入的数的个数
        int[] bucketElementCounts = new int[10];

//        //第1轮（针对每个元素的个位进行排序处理）
//        for (int i = 0; i < array.length; i++) {
//            //取出每个元素的个位的值
//            int digitOfElement = array[i] % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[i];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
//        int index = 0;
//        //遍历每一个桶，并将桶中的数据放入到原数组
//        for (int i = 0; i < bucketElementCounts.length; i++) {
//            //如果桶中有数据，才放入原数组
//            if (bucketElementCounts[i] != 0) {
//                //循环该桶即第i个桶（即第i个一维数组），放入
//                for (int j = 0; j < bucketElementCounts[i]; j++) {
//                    //取出元素放入到array
//                    array[index++] = bucket[i][j];
//                }
//            }
//            //第一轮处理后，需要将每个bucketElementCounts[i]置为0
//            bucketElementCounts[i] = 0;
//        }

        //推广
        //找出array中最大的数的位数
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = String.valueOf(max).length();
        //将上述代码进行循环处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //第i+1轮（针对每个元素的对应位进行排序处理），第一次是个位，第二次是十位，第三次是百位。。。
            for (int l = 0; l < array.length; l++) {
                //取出每个元素的对应位的值
                int digitOfElement = array[l] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[l];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才放入原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶（即第k个一维数组），放入
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        //取出元素放入到array
                        array[index++] = bucket[k][j];
                    }
                }
                //第i+1轮处理后，需要将每个bucketElementCounts[k]置为0
                bucketElementCounts[k] = 0;
            }
        }
    }

}
