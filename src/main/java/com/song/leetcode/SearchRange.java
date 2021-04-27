package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{7, 8, 8, 8, 9}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                count++;
//                if (count == 1) {
//                    res[0] = i;
//                }
//                res[1] = i;
//            }
//        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                //相同值处理
                int temp = mid - 1;
                while (temp >= 0 && nums[temp] == target) {
                    //向左继续查找相等的值
                    temp -= 1;
                }
                res[0] = temp + 1;
                temp = mid + 1;
                while (temp <= nums.length - 1 && nums[temp] == target) {
                    //向右继续查找相等的值
                    temp += 1;
                }
                res[1] = temp - 1;
                return res;
            } else if (nums[mid] > target) {
                //向左继续查找
                right = mid - 1;
            } else {
                //向右继续查找
                left = mid + 1;
            }
        }
        return res;
    }
}
