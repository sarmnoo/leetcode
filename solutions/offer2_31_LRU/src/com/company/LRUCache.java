package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * lru:移除最近最少使用的节点
 * get：根据key获取某个节点，若获取到，则将该节点移到链表头部，表示最近使用过
 * put:存入某个节点，先判断之前是否有该Key,若有，则将该节点的值进行修改，并移动该节点到链表头部；
 *                                   若没有，则将该节点放入链表头部，并判断此时cache容量是否超限，若超限，则移除尾部节点，即移除最近最少使用节点。
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Node> nodeMap;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        nodeMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node != null) {
            moveNodeToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            nodeMap.put(key, node);
            size ++;
            addNode(node);
            //如果超过capacity，则移除末尾节点
            if(size > capacity) {
                Node delNode = tail.pre;
                removeNode(delNode);
                nodeMap.remove(delNode.key);
                size --;
            }
        } else {
            //已有key节点，只是改变map中value,并把该节点移到头部
            node.value = value;
            nodeMap.put(key, node);
            moveNodeToHead(node);
        }



    }

    private void moveNodeToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node){
        Node headNext = head.next;
        head.next = node;
        node.pre = head;
        node.next = headNext;
        headNext.pre = node;
    }

    private void removeNode(Node node) {
        Node curNext = node.next;
        Node curPre = node.pre;
        curPre.next = curNext;
        curNext.pre = curPre;
    }



}
