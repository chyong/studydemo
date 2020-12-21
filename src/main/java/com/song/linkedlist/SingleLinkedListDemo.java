package com.song.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(3, "小吴用", "智多星*&*……*");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHeroByOrder(hero4);
        singleLinkedList.addHeroByOrder(hero3);
        singleLinkedList.addHeroByOrder(hero1);
        singleLinkedList.addHeroByOrder(hero2);
//        singleLinkedList.deleteHero(hero5);
        singleLinkedList.showHero();
        System.out.println(singleLinkedList.getHeroNum());
//        System.out.println(singleLinkedList.getLastHero(3));
        singleLinkedList.reverseHero_1();
        singleLinkedList.showHero();
        System.out.println(singleLinkedList.getHeroNum());
        singleLinkedList.reverseHero_2();
        singleLinkedList.showHero();
        System.out.println(singleLinkedList.getHeroNum());
        singleLinkedList.reversePrint();
    }

}

class SingleLinkedList {

    private final HeroNode head = new HeroNode(0, "", "");

    public void addHero(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                //去重
                return;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addHeroByOrder(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                //去重
                return;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void updateHero(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                temp.next.nikName = node.nikName;
                temp.next.name = node.name;
                break;
            }
            temp = temp.next;
        }
    }

    public void deleteHero(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void showHero() {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.toString());
        }
    }

    public int getHeroNum() {
        HeroNode temp = head;
        int i = 0;
        while (temp.next != null) {
            i++;
            temp = temp.next;
        }
        return i;
    }

    public HeroNode getLastHero(int a) {
        HeroNode temp = head;
        for (int i = 0; i <= getHeroNum() - a; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void reverseHero_1() {
        HeroNode temp = head;
        HeroNode reserveHead = null;
        while (temp.next != null) {
            reserveHead = new HeroNode(temp.next.no, temp.next.name, temp.next.nikName, reserveHead);
            temp = temp.next;
        }
        head.next = reserveHead;
    }

    public void reverseHero_2() {
        HeroNode temp = head;
        HeroNode next;
        HeroNode reserveHead = new HeroNode(0, "", "");
        while (temp.next != null) {
            next = temp.next.next;
            temp.next.next = reserveHead.next;
            reserveHead.next = temp.next;
            temp.next = next;
        }
        head.next = reserveHead.next;
    }

    public void reversePrint() {
        HeroNode temp = head;
        Stack<HeroNode> stack = new Stack<>();
        while (temp.next != null) {
            stack.add(temp.next);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nikName;
    public HeroNode next;

    public HeroNode(int no, String name, String nikName) {
        this.name = name;
        this.nikName = nikName;
        this.no = no;
    }

    public HeroNode(int no, String name, String nikName, HeroNode next) {
        this.name = name;
        this.nikName = nikName;
        this.no = no;
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikName='" + nikName + '\'' +
                '}';
    }
}