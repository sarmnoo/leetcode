package com.company;

import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    // write your code here
    }

    public void reorderList(ListNode head) {
        Stack<ListNode> nodes = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            nodes.push(temp);
            temp = temp.next;
        }

        temp = head;
        ListNode node = null;
        ListNode nextNode = null;
        while(!nodes.isEmpty() && temp != null && temp != nodes.peek() && temp.next != nodes.peek() ) {
            node = nodes.pop();
            nextNode = temp.next;
            temp.next = node;
            node.next = nextNode;
            temp = nextNode;
        }
        if (temp == nodes.peek()) {
            temp.next = null;
        } else {
            temp = temp.next;
            if(temp!= null) {
                temp.next = null;
            }
        }



    }
}
