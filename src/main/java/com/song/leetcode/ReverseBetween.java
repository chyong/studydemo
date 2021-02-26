package com.song.leetcode;

/**
 * 92.反转链表II
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(9, l3);
        ListNode l5 = new ListNode(8, l4);
        ListNode l6 = new ListNode(7, l5);
        printNode(reverseBetween(l6, 2, 5));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //a为移动节点，b为连接第1部分和第2部分的节点，d为第2部分新建翻转链表的插入节点，e为连接第2部分和第3部分的节点
        ListNode a = head, b = head, d, e = null;
        //创建第2部分翻转链表的哑节点
        ListNode dummy = new ListNode(0);
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                b = a;
            } else {
                //将第2部分的值存进新建的翻转链表
                ListNode guard = dummy.next;
                d = new ListNode(a.val);
                dummy.next = d;
                //记录第一个存进链表的值用来和第3部分连接
                if (i == m) {
                    e = d;
                }
                dummy.next.next = guard;
            }
            a = a.next;
        }
        //特殊情况，当m=1的时候会将头节点存储2遍
        if (m == 1) {
            if (e != null) e.next = a;
            return dummy.next;
        }
        b.next = dummy.next;
        e.next = a;
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
