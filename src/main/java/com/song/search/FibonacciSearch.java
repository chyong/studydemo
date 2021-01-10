package com.song.search;

import java.util.Arrays;

public class FibonacciSearch {

    static int maxSize = 20;

    public static void main(String[] args) {
        //斐波那契查找实现
        int[] array = new int[100];
        for (int i = 1; i < 101; i++) {
            array[i - 1] = i;
        }
//        int[] array = {1, 8, 10, 89, 1000, 1234};
        System.out.println("查找返回的结果集：" + fibSearch(array, 56));
    }

    //非递归得到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 非递归实现斐波那契查找
     *
     * @param array 目标数组
     * @param key   要查找的数
     * @return
     */
    public static int fibSearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放mid的值
        int[] f = fib();//获取斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于a的长度，因此我们需要使用Array类，构造一个新的数组，并指向array[]
        int[] temp = Arrays.copyOf(array, f[k]);
        //实际上需要使用array[]数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = array[high];
        }
        while (low <= high) {//只要满足该条件就可以继续找
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//我们应该继续向数组的前面查找（左边）
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }

}