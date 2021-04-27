package com.song.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141.环形链表
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(9, l3);
        ListNode l5 = new ListNode(8, l4);
        ListNode l6 = new ListNode(7, l5);
        System.out.println(hasCycle(l6));
    }

    public static boolean hasCycle(ListNode head) {
//        Set<ListNode> seen = new HashSet<>();
//        while (head != null) {
//            if (!seen.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;


        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
