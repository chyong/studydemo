package com.song.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        //二分查找非递归实现
//        int[] array = new int[100];
//        for (int i = 1; i < 101; i++) {
//            array[i - 1] = i;
//        }
        int[] array = {1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 9};
        System.out.println("查找返回的结果集：" + binarySearch(array, 0, array.length - 1, 6));
    }

    /**
     * 二分查找非递归实现
     *
     * @param array
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List<Integer> binarySearch(int[] array, int left, int right, int findVal) {
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == findVal) {
                //相同值处理
                int temp = mid - 1;
                while (temp >= 0 && array[temp] == findVal) {
                    //向左继续查找相等的值
                    list.add(temp);
                    temp -= 1;
                }
                list.add(mid);
                temp = mid + 1;
                while (temp <= array.length - 1 && array[temp] == findVal) {
                    //向右继续查找相等的值
                    list.add(temp);
                    temp += 1;
                }
                return list;
            } else if (array[mid] > findVal) {
                //向左继续查找
                right = mid - 1;
            } else {
                //向右继续查找
                left = mid + 1;
            }
        }
        return list;
    }

}
