package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        PriorityQueue priorityQueue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                priorityQueue.offer(lists[i]);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode minNode = (ListNode) priorityQueue.poll();
            temp.next = minNode;
            temp = temp.next;
            if (minNode.next != null) {
                priorityQueue.offer(minNode.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        ListNode ret = solution.mergeKLists(new ListNode[]{});

    }
}
