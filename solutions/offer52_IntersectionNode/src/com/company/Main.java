package com.company;

import java.util.Stack;

public class Main {

    /**
     * 利用栈来倒排链表 空间复杂度比较高
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null) {
            stackA.push(tempA);
            tempA = tempA.next;
        }

        while(tempB != null) {
            stackB.push(tempB);
            tempB = tempB.next;
        }

        ListNode common = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek().equals(stackB.peek())) {
                common = stackA.peek();
                stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        return common;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        ListNode commonNode = null;
        while (tempA != tempB) {
            tempA = tempA == null? headB:tempA.next;
            tempB = tempB == null? headA:tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
