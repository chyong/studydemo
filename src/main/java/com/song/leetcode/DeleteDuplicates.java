package com.song.leetcode;

/**
 * 83.删除排序链表中的重复元素
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(2, l4);
        ListNode l6 = new ListNode(1, l5);
        printNode(deleteDuplicates(l6));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if (null == head) return null;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void printNode(ListNode node) {
        while (node.next != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print(node.val);
    }
}
