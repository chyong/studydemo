package com.song.leetcode;

/**
 * 19.删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(9, l3);
        ListNode l5 = new ListNode(8, l4);
        ListNode l6 = new ListNode(7, l5);
        printNode(removeNthFromEnd(l6, 4));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        int index = getLength(head) - n;
//        if (index == -1) return head.next;
//        ListNode cur = head;
//        while (cur.next != null) {
//            index--;
//            if (index == -1) {
//                cur.next = cur.next.next;
//                break;
//            }
//            cur = cur.next;
//        }
//        return head;
        //快慢指针
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length;
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
