package com.company;

import java.util.Stack;

public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<Integer> retStack = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        while(l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        int mode = 0;
        int sum = 0;
        while (!stack1.empty() || !stack2.empty()) {
            if (stack1.empty()) {
                sum = stack2.pop().val + mode;
            } else if (stack2.empty()) {
                sum = stack1.pop().val + mode;
            } else {
                sum = stack1.pop().val + stack2.pop().val + mode;
            }

            retStack.push(sum % 10);
            mode = sum / 10;
        }

        if (mode == 1) {
            retStack.push(mode);
        }

        ListNode temp = ret;
        while (!retStack.empty()) {
            ListNode node = new ListNode(retStack.pop());
            temp.next = node;
            temp = temp.next;
        }

        return ret.next;
    }

    public static void main(String[] args) {

    }
}
