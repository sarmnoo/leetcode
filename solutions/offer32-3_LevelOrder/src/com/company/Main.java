package com.company;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<>();

        if (root == null) {
            return lists;
        }
        nodeQueue.offer(root);
        boolean isReverse = false;
        while (!nodeQueue.isEmpty()) {
            //ArrayList<Integer> integers = new ArrayList<>();
            //linkedList 底层双向链表，可以在头部添加元素也可在尾部添加元素
            LinkedList<Integer> integers = new LinkedList<>();
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode node = nodeQueue.poll();
                if (isReverse) {
                    //需要倒序的在头部加入元素
                    integers.addFirst(node.val);
                } else {
                    integers.add(node.val);
                }
                if (node.left != null) nodeQueue.offer(node.left);
                if (node.right != null) nodeQueue.offer(node.right);
            }
//            if (isReverse) {
//                Collections.reverse(integers);
//            }
            isReverse = isReverse == false ? true : false;
            lists.add(integers);
        }
        return lists;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
