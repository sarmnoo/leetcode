package com.company;

import com.sun.jdi.connect.spi.TransportService;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {

    class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {

        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;
    private Map<Integer, LinkedNode> cache = new HashMap<Integer, LinkedNode>();
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        //更新缓存，按照Lru算法，应将node节点移动至头节点处
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LinkedNode linkedNode = cache.get(key);
        if (linkedNode == null) {
            //新节点，加入cache，并插入到头结点
            LinkedNode node = new LinkedNode(key, value);
            addNode(node);
            cache.put(key, node);
            size ++;
            if (size > capacity) {
                //移除最近最少被使用的节点，即从缓存中删除尾结点,从双向链表中删除节点
                LinkedNode delNode = tail.pre;
                removeNode(delNode);
                cache.remove(delNode.key);
            }
        } else {
            //存在cache中，只是value变了，需要更新value,并更新到头结点
            linkedNode.value = value;
            moveToHead(linkedNode);
            cache.put(key, linkedNode);
        }

    }

    public void moveToHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public void removeNode(LinkedNode node) {
        LinkedNode pre = node.pre;
        LinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public void addNode(LinkedNode node) {
        LinkedNode next = head.next;
        head.next = node;
        node.next = next;
        next.pre = node;
        node.pre = head;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(1, 1); // 缓存是 {1=1, 2=2}
//        System.out.println(lRUCache.get(1)); // 返回 1
        lRUCache.put(2, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2)); // 返回 -1 (未找到)
        lRUCache.put(4, 1); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));  // 返回 -1 (未找到)
        System.out.println(lRUCache.get(2));  // 返回 3
//        System.out.println(lRUCache.get(4));
    }
}
