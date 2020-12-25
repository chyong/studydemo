package com.song.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(2, "小吴用", "智多星*&*……*");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addHeroByOrder(hero4);
        doubleLinkedList.addHeroByOrder(hero3);
        doubleLinkedList.addHeroByOrder(hero1);
        doubleLinkedList.addHeroByOrder(hero2);
//        doubleLinkedList.deleteHero(hero5);
//        doubleLinkedList.updateHero(hero5);
        doubleLinkedList.showHero();
//        System.out.println(singleLinkedList.getHeroNum());
//        System.out.println(singleLinkedList.getLastHero(3));
//        singleLinkedList.reverseHero_1();
//        singleLinkedList.showHero();
//        System.out.println(singleLinkedList.getHeroNum());
//        singleLinkedList.reverseHero_2();
//        singleLinkedList.showHero();
//        System.out.println(singleLinkedList.getHeroNum());
//        singleLinkedList.reversePrint();
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

class DoubleLinkedList {

    private final HeroNode2 head = new HeroNode2(0, "", "");

    public void addHero(HeroNode2 node) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                //去重
                return;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void addHeroByOrder(HeroNode2 node) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                //去重
                return;
            }
            temp = temp.next;
        }
        if(temp.next!=null){
            node.next = temp.next;
            temp.next.pre = node;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void updateHero(HeroNode2 node) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                temp.next.nikName = node.nikName;
                temp.next.name = node.name;
            }
            temp = temp.next;
        }
    }

    public void deleteHero(HeroNode2 node) {
        HeroNode2 temp = head.next;
        while (temp != null) {
            if (temp.no == node.no) {
                temp.pre.next = temp.next;
                if (temp.next != null)
                    temp.next.pre = temp.pre;
            }
            temp = temp.next;
        }
    }

    public void showHero() {
        HeroNode2 temp = head;
        System.out.println("正向遍历：");
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.toString());
        }
        System.out.println("反向遍历：");
        while (temp.pre != null) {
            System.out.println(temp.toString());
            temp = temp.pre;
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


class HeroNode2 {
    public int no;
    public String name;
    public String nikName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nikName) {
        this.name = name;
        this.nikName = nikName;
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikName='" + nikName + '\'' +
                '}';
    }
}