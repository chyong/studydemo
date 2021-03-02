package com.song.leetcode;

/**
 * 206.反转链表
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(9, l3);
        ListNode l5 = new ListNode(8, l4);
        ListNode l6 = new ListNode(7, l5);
        printNode(reverseList(l6));
    }

    public static ListNode reverseList(ListNode head) {
//        ListNode reserveHead = null;
//        while (head != null) {
//            reserveHead = new ListNode(head.val, reserveHead);
//            head = head.next;
//        }
//        return reserveHead;
        //迭代法
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printNode(ListNode node) {
        while (node.next != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print(node.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

}
