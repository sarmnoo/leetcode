package com.company;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedBlockingQueue<>();
        treeNodes.offer(root);
        int ret = root.val;
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            boolean isleft = true;
            while (size > 0) {
                TreeNode node = treeNodes.poll();
                if (isleft) {
                    ret = node.val;
                    isleft = false;
                }
                size --;
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }
                if (node.right != null) {
                    treeNodes.offer(node.right);
                }
            }
        }
        return ret;

    }
}
