package com.song.linkedlist;

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
        singleLinkedList.deleteHero(hero5);
        singleLinkedList.showHero();
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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikName='" + nikName + '\'' +
                '}';
    }
}