package com.company;

public class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }

    public Node() {
        
    }
}
