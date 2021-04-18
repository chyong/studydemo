package com.song.leetcode;

/**
 * 2.两数相加
 */
public class TwoTogether {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);

        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(8, l4);
        ListNode l6 = new ListNode(7, l5);
        System.out.print(addTwoNumbers(l3, l6).val + " -> ");
        System.out.print(addTwoNumbers(l3, l6).next.val + " -> ");
        System.out.println(addTwoNumbers(l3, l6).next.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            if (l1 != null) {
                temp = temp + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp = temp + l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(temp % 10);
            temp = temp / 10;
            curr = curr.next;
        }
        return dummyHead.next;
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

    }

}
