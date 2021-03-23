package com.company;

import java.util.Stack;

public class Main {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        Stack<Node> nodeList = new Stack<>();
        Node pre = null;
        Node head = null;
        Node temp = root;
        while (temp != null) {
            nodeList.push(temp);
            temp = temp.left;
        }
        while (!nodeList.isEmpty()) {
            Node popNode = nodeList.pop();
            temp = popNode.right;
            while (temp != null) {
                nodeList.push(temp);
                temp = temp.left;
            }
            if (head == null) {
                head = popNode;
            }
            if (pre == null) {
                pre = popNode;
            } else {
                pre.right = popNode;
                popNode.left = pre;
                pre = popNode;
            }
        }


        head.left = pre;
        pre.right = head;
        return head;
    }


    public static void main(String[] args) {
	// write your code here
    }
}
