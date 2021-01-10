package com.song.search;

import java.util.ArrayList;
import java.util.List;

public class InsertValueSearch {


    static int count = 0;

    public static void main(String[] args) {
        //插值查找实现
        int[] array = new int[100];
        for (int i = 1; i < 101; i++) {
            array[i - 1] = i;
        }
//        int[] array = {1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 9};
        System.out.println("查找返回的结果集：" + insertValueSearch(array, 0, array.length - 1, 56));
        System.out.println("查找次数：" + count);
    }

    /**
     * 递归进行插值查找
     *
     * @param array
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List<Integer> insertValueSearch(int[] array, int left, int right, int findVal) {
        count++;
        List<Integer> list = new ArrayList<>();
        if (left > right || findVal < array[0] | findVal > array[array.length - 1]) {
            return list;
        }
        //插值查找的精髓 公式：mid = left + (right - left) * (findVal - array[left]) / (array[right] - array[left])，自适应
        int mid = left + (right - left) * (findVal - array[left]) / (array[right] - array[left]);
        int midValue = array[mid];
        if (midValue < findVal) {
            //向右递归查找
            return insertValueSearch(array, mid + 1, right, findVal);
        } else if (midValue > findVal) {
            //向左递归查找
            return insertValueSearch(array, left, mid - 1, findVal);
        } else {
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
        }
    }

}
