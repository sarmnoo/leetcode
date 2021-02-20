public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode current = head;
        ListNode preNext = null;
        ListNode curNext = null;
        while(current.next != null) {
            preNext = pre.next;
            curNext = current.next;

            pre.next = curNext;
            current.next = curNext.next;
            curNext.next = preNext;
        }
        return pre.next;
    }

}
