package com.song.leetcode;

/**
 * 4.寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4, 5}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 合成的数组
        int[] res = new int[len1 + len2];
        int index = 0;
        int left = 0, right = 0;
        // 归并排序合成部分
        while (left < len1 && right < len2) {
            if (nums1[left] < nums2[right]) {
                res[index++] = nums1[left++];
            } else {
                res[index++] = nums2[right++];
            }
        }
        // 判断nums1剩余还是nums2剩余，并将剩余部分加入到合成的数组之后
        while (left < len1) {
            res[index++] = nums1[left++];
        }
        while (right < len2) {
            res[index++] = nums2[right++];
        }
        // 判断合成后的数组的长度，求出中位数。返回的是double类型
        if ((len1 + len2) % 2 == 1) {
            return res[(len1 + len2) / 2];
        } else {
            return (double) (res[(len1 + len2) / 2] + res[(len1 + len2) / 2 - 1]) / 2;
        }
    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        // left用来保存上一次遍历的结果，right表视当前遍历的结果。因为偶数时：需要两个值
        int left = -1, right = -1;
        // aStart指向此时A数组的位置，bStart指向此时B数组的位置
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            // 每次开始新的一边遍历时，保存上次的遍历结果
            left = right;
            // 数组A指针aStart后移的条件：aStart没有到A的最后，此时A位置的数字小于B位置的数字。此时要判断B的指针bStart是否越界，如果越界的话就不去判断此时A位置的值与B位置的值的大小，而是继续遍历A当前位置的值。
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

}
