package com.company;

public class Main {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null) {
            lenA ++;
            tempA = tempA.next;
        }
        while(tempB != null) {
            lenB ++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;
        int sub = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while(sub > 0) {
                tempA = tempA.next;
                sub --;
            }
        } else {
            while(sub > 0) {
                tempB = tempB.next;
                sub --;
            }
        }
        while (tempB != tempA) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
