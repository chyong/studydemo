package com.song.binarytree;

import java.util.Stack;

public class BinaryTreeDemo {
    //二叉树前、中、后序遍历
    public static void main(String[] args) {
        BinaryTree_2 binaryTree = new BinaryTree_2();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode hero1 = new HeroNode(2, "吴用");
        HeroNode hero2 = new HeroNode(3, "卢俊义");
        HeroNode hero3 = new HeroNode(4, "林冲");
        HeroNode hero4 = new HeroNode(5, "关胜");
        root.setLeft(hero1);
        root.setRight(hero2);
        hero2.setLeft(hero4);
        hero2.setRight(hero3);
        System.out.println("前序遍历：");
        binaryTree.preOrder(root);
        System.out.println("中序遍历：");
        binaryTree.infixOrder(root);
        System.out.println("后序遍历：");
        binaryTree.postOrder(root);
    }
}

/*
递归实现
 */
class BinaryTree_1 {
    //前序遍历
    public void preOrder(HeroNode root) {
        System.out.println(root);
        //递归查找左子树
        if (root.getLeft() != null) {
            preOrder(root.getLeft());
        }
        //递归查找右子树
        if (root.getRight() != null) {
            preOrder(root.getRight());
        }
    }

    //中序遍历
    public void infixOrder(HeroNode root) {
        //递归查找左子树
        if (root.getLeft() != null) {
            infixOrder(root.getLeft());
        }
        System.out.println(root);
        //递归查找右子树
        if (root.getRight() != null) {
            infixOrder(root.getRight());
        }
    }

    //后序遍历
    public void postOrder(HeroNode root) {
        //递归查找左子树
        if (root.getLeft() != null) {
            postOrder(root.getLeft());
        }
        //递归查找右子树
        if (root.getRight() != null) {
            postOrder(root.getRight());
        }
        System.out.println(root);
    }
}

/*
堆栈实现
 */
class BinaryTree_2 {
    //前序遍历
    public void preOrder(HeroNode root) {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode node = root;
        while (node != null || stack.size() > 0) {  //将所有左子树压栈
            if (node != null) {   //压栈之前先访问
                System.out.println(node);
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    //中序遍历
    public void infixOrder(HeroNode root) {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //直接压栈
                node = node.getLeft();
            } else {
                node = stack.pop(); //出栈并访问
                System.out.println(node);
                node = node.getRight();
            }
        }
    }

    //后序遍历
    public void postOrder(HeroNode root) {
        Stack<HeroNode> stack = new Stack<>();
        Stack<HeroNode> output = new Stack<>();//构造一个中间栈来存储逆后序遍历的结果
        HeroNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRight();//因为最后要出栈，所以先压入右子树
            } else {
                node = stack.pop();
                node = node.getLeft();
            }
        }
        while (output.size() > 0) {
            System.out.println(output.pop());
        }
    }
}

class HeroNode {
    private final int no;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}