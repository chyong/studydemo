package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 82.删除排序链表中的重复元素II
 */
public class DeleteDuplicatesII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(2, l3);
        ListNode l5 = new ListNode(1, l4);
        ListNode l6 = new ListNode(1, l5);
        printNode(deleteDuplicates(l6));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        if(null==head) return null;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                list.add(temp.val);
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        ListNode temp1 = head;
        while(temp1.next!=null){
            if(list.contains(temp1.val)){
                temp1=temp1.next.next;
            }else{
                temp1=temp1.next;
            }

        }
        System.out.println(list);
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
