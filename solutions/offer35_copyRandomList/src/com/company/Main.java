package com.company;

public class Main {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        //在每个节点后复制当前节点
        //1->2->3 复制后 1->1clone->2->2clone->3->3clone->null
        Node node = head;
        while(node != null) {
            Node cloneNode = new Node(node.val);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }

        //将每个节点的random节点赋值给克隆节点
        node = head;
        while (node != null) {
            if (node.random != null) node.next.random = node.random.next;
            node = node.next.next;
        }

        //剥离出克隆出的节点
        Node pre = new Node(-1);
        Node headTemp = pre;
        node = head;
        while(node != null) {
            pre.next = node.next;
            node.next = node.next.next;
            node = node.next;
            pre = pre.next;
        }
        return headTemp.next;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
