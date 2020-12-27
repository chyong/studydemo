package com.song.linkedlist;

public class CircleSingleLinkedListDemo {

    //约瑟夫问题（环形链表实现）
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoys(5);
//        circleSingleLinkedList.showBoys();
        circleSingleLinkedList.countBoy(1, 2);
    }

}

class CircleSingleLinkedList {

    private Boy first = new Boy(-1);

    public void addBoys(int nums) {
        if (nums < 1) {
            System.out.println("孩子数必须大于1");
        }
        Boy curBoy = null;
        //添加孩子节点
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoys() {
        Boy curBoy = first;
        while (true) {
            System.out.println("孩子编号：" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void countBoy(int startNo, int countNums) {
        //helperBoy指向最后一个孩子节点
        Boy helperBoy = first;
        while (helperBoy.getNext() != first) {
            helperBoy = helperBoy.getNext();
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helperBoy = helperBoy.getNext();
        }

        while (first != helperBoy) {
            for (int i = 0; i < countNums - 1; i++) {
                first = first.getNext();
                helperBoy = helperBoy.getNext();
            }
            System.out.println("出圈孩子编号：" + first.getNo());
            first = first.getNext();
            helperBoy.setNext(first);
        }
        System.out.println("～～幸运孩子编号：" + first.getNo());
    }

}

class Boy {

    private int no;

    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}