package com.song.sort;

import java.util.Arrays;

public class MergeSort {

    //归并排序
    public static void main(String[] args) {
//        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //创建80000个随机数的数组
        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 8000000);
        }
        int[] temp = new int[array.length];
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        mergeSort(array, 0, array.length - 1, temp);
        long end = System.currentTimeMillis();
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
        System.out.println("总耗时：" + (end - start) + "ms");

    }

    //分+合的方法
    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归进行分解
            mergeSort(array, left, mid, temp);
            //向右递归进行分解
            mergeSort(array, mid + 1, right, temp);
            //合并
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 合并方法
     *
     * @param array 排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i为左边有序序列的初始索引
        int j = mid + 1;//初始化j为右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引
        //先把左右两边有序的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素，即将左边的当前元素，填充到temp数组，然后t++，i++
            if (array[i] <= array[j]) {
                temp[t] = array[i];
                t += 1;
                i += 1;
            } else {
                //反之，将右边有序序列的当前元素，填充到temp数组
                temp[t] = array[j];
                t += 1;
                j += 1;
            }
        }
        //把有剩余数据的一边的数据全部填充到temp
        while (i <= mid) {
            //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = array[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = array[j];
            t += 1;
            j += 1;
        }
        //将temp数组的元素拷贝到array，注意并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //第一次合并tempLeft=0，right=1，然后依次tempLeft=2，right=3，tempLeft=0，right=3。。。最后一次tempLeft=0，right=7
//        System.out.println("tempLeft=" + tempLeft + "，right=" + right);
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

}
