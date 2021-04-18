package com.song.leetcode;

/**
 * 21.合并两个有序链表
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(8, l4);
        ListNode l6 = new ListNode(7, l5);
        printNode(mergeTwoLists(l3, l6));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        } else if (l2 == null) {
//            return l1;
//        } else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
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

class ListNode {
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

