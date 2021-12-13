package com.company;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CBTInserter {

    private TreeNode root = null;
    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
        TreeNode insertNode = new TreeNode(v);
        Queue<TreeNode> nodes = new LinkedBlockingQueue<>();
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            TreeNode cur = nodes.poll();
            if (cur.left == null) {
                cur.left = insertNode;
                return cur.val;
            }
            nodes.offer(cur.left);
            if (cur.right == null) {
                cur.right = insertNode;
                return cur.val;
            }
            nodes.offer(cur.right);
        }
        return v;
    }

    public TreeNode get_root() {
        return root;
    }
}
