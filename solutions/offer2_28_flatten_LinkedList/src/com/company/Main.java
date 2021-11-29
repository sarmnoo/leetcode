package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Stack<Node> nodes = new Stack<>();

        nodes.push(head);
        Node cur = null;
        Node pre = new Node();
        while(!nodes.isEmpty()) {
            cur = nodes.pop();
            pre.next = cur;
            cur.prev = pre;
            pre = cur;
            if (cur.next != null) {
                nodes.push(cur.next);
            }
            if (cur.child != null) {
                nodes.push(cur.child);
            }
            cur.child = null;
        }
        head.prev = null;

        return head;
    }
}
