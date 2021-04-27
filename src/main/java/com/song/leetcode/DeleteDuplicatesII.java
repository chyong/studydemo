package com.song.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 82.删除排序链表中的重复元素II
 */
public class DeleteDuplicatesII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(1, l4);
        ListNode l6 = new ListNode(1, l5);
        printNode(deleteDuplicates(l6));
    }

    public static ListNode deleteDuplicates(ListNode head) {
//        Map<Integer, Integer> map = new HashMap<>();
//        ListNode temp = head;
//        if (null == head) return null;
//        while (temp.next != null) {
//            if (temp.val == temp.next.val) {
//                map.put(temp.val, temp.val);
//                temp.next = temp.next.next;
//            } else {
//                temp = temp.next;
//            }
//        }
//        ListNode temp2 = new ListNode(0);
//        temp2.next = head;
//        temp = temp2;
//        while (temp.next != null) {
//            if (map.get(temp.next.val) != null) {
//                temp.next = temp.next.next;
//            } else {
//                temp = temp.next;
//            }
//
//        }
//        return temp2.next;
//        ListNode res = new ListNode(0, head);
//        ListNode temp = res;
//        if (null == head) return null;
//        while (temp.next != null && temp.next.next != null) {
//            if (temp.next.val == temp.next.next.val) {
//                int x = temp.next.val;
//                while (temp.next != null && temp.next.val == x) {
//                    temp.next = temp.next.next;
//                }
//            } else {
//                temp = temp.next;
//            }
//        }
//        return res.next;
        ListNode res = new ListNode(0, head);
        ListNode temp = res;
        if (null == head) return null;
        while (temp.next != null && temp.next.next != null) {
            if (temp.next.val == temp.next.next.val) {
                int x = temp.next.val;
                while (temp.next != null && x == temp.next.val) {
                    temp.next = temp.next.next;
                }
            } else {
                temp = temp.next;
            }
        }
        return res.next;
    }

    public static void printNode(ListNode node) {
        while (node.next != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print(node.val);
    }
}
