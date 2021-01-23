package com.song.leetcode;

/**
 * 两数相加
 */
public class TwoTogether {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6, l4);
        ListNode l6 = new ListNode(5, l5);
        System.out.print(addTwoNumbers(l3, l6).val + " -> ");
        System.out.print(addTwoNumbers(l3, l6).next.val + " -> ");
        System.out.println(addTwoNumbers(l3, l6).next.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
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
