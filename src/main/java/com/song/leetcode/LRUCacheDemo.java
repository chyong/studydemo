package com.song.leetcode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 146.LRU缓存机制
 */
public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);
    }
}


class LRUCache {

    static class DoubleLinkedNode {
        //双向链表
        public int key;
        public int value;
        public DoubleLinkedNode next;
        public DoubleLinkedNode prev;

        @Override
        public String toString() {
            return "{key=" + key +
                    ", value=" + value + '}';
        }
    }

    private void addNode(DoubleLinkedNode node) {
        //头插法
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode next = node.next;
        DoubleLinkedNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    private void moveToHead(DoubleLinkedNode node) {
        //将节点移动到首位
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode popTail() {
        //将末尾节点删除，并返回删除的节点
        DoubleLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private final ConcurrentHashMap<Integer, DoubleLinkedNode> cache = new ConcurrentHashMap<>();

    private int size;

    private final int capacity;

    private final DoubleLinkedNode head;

    private final DoubleLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            System.out.println(cache);
            return -1;
        } else {
            //返回value，并将该节点移至首位
            moveToHead(node);
            System.out.println(cache);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            //不存在key与之相等的，新增节点
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            cache.put(key, newNode);
            size++;
            //判断size是否大于capacity，如果大于，删除尾节点
            if (size > capacity) {
                DoubleLinkedNode delNode = popTail();
                cache.remove(delNode.key);
                size--;
            }
        } else {
            //存在key与之相等的，覆盖节点，并将该节点移至首位
            node.value = value;
            moveToHead(node);
            cache.put(key, node);
        }
        System.out.println(cache);
    }
}
