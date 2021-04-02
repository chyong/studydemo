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
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode popTail() {
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
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) return -1;
        //将节点移到链表头部
        moveToHead(node);
        System.out.println(cache);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            //不存在则新增节点
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if (size > capacity) {
                //如果缓存满了，则删除最后一个节点
                DoubleLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            //存在则更新节点
            node.value = value;
            moveToHead(node);
        }
        System.out.println(cache);
    }

}
