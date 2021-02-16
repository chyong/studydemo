package com.song.leetcode;

import java.util.Arrays;

/**
 * 215.数组中的第K个最大元素
 */
public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        radixSort(nums);
        return nums[nums.length - k];
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

//    public static void mergeSort(int[] array, int left, int right, int[] temp) {
//        if (left < right) {
//            int mid = (left + right) / 2;//中间索引
//            //向左递归进行分解
//            mergeSort(array, left, mid, temp);
//            //向右递归进行分解
//            mergeSort(array, mid + 1, right, temp);
//            //合并
//            merge(array, left, mid, right, temp);
//        }
//    }
//
//    /**
//     * 合并方法
//     *
//     * @param array 排序的原始数组
//     * @param left  左边有序序列的初始索引
//     * @param mid   中间索引
//     * @param right 右边索引
//     * @param temp  做中转的数组
//     */
//    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
//        int i = left;//初始化i为左边有序序列的初始索引
//        int j = mid + 1;//初始化j为右边有序序列的初始索引
//        int t = 0;//指向temp数组的当前索引
//        //先把左右两边有序的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
//        while (i <= mid && j <= right) {
//            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素，即将左边的当前元素，填充到temp数组，然后t++，i++
//            if (array[i] <= array[j]) {
//                temp[t] = array[i];
//                t += 1;
//                i += 1;
//            } else {
//                //反之，将右边有序序列的当前元素，填充到temp数组
//                temp[t] = array[j];
//                t += 1;
//                j += 1;
//            }
//        }
//        //把有剩余数据的一边的数据全部填充到temp
//        while (i <= mid) {
//            //左边的有序序列还有剩余的元素，就全部填充到temp
//            temp[t] = array[i];
//            t += 1;
//            i += 1;
//        }
//        while (j <= right) {
//            //右边的有序序列还有剩余的元素，就全部填充到temp
//            temp[t] = array[j];
//            t += 1;
//            j += 1;
//        }
//        //将temp数组的元素拷贝到array，注意并不是每次都拷贝所有
//        t = 0;
//        int tempLeft = left;
//        //第一次合并tempLeft=0，right=1，然后依次tempLeft=2，right=3，tempLeft=0，right=3。。。最后一次tempLeft=0，right=7
////        System.out.println("tempLeft=" + tempLeft + "，right=" + right);
//        while (tempLeft <= right) {
//            array[tempLeft] = temp[t];
//            t += 1;
//            tempLeft += 1;
//        }
//    }

//    public static void quickSort(int[] arr, int start, int end) {
//        int pivot = arr[start];
//        int i = start;
//        int j = end;
//        while (i < j) {
//            while ((i < j) && (arr[j] > pivot)) {
//                j--;
//            }
//            while ((i < j) && (arr[i] < pivot)) {
//                i++;
//            }
//            if ((arr[i] == arr[j]) && (i < j)) {
//                i++;
//            } else {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//        if (i - 1 > start) quickSort(arr, start, i - 1);
//        if (j + 1 < end) quickSort(arr, j + 1, end);
//    }
}
