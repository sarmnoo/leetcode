package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {


    class LevelNode {
        TreeNode node;
        int level;

        LevelNode(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        Queue<LevelNode> nodeList = new LinkedBlockingQueue<>();
        nodeList.offer(new LevelNode(root, 0));
        while(!nodeList.isEmpty()) {
            LevelNode top = nodeList.poll();
            TreeNode treeNode = top.node;
            int levelNum = top.level;
            if (lists.size() <= levelNum) {
                lists.add(levelNum, new ArrayList<Integer>());
            }
            lists.get(levelNum).add(treeNode.val);
            if (treeNode.left != null) {
                nodeList.offer(new LevelNode(treeNode.left, levelNum + 1));
            }
            if (treeNode.right != null) {
                nodeList.offer(new LevelNode(treeNode.right, levelNum + 1));
            }
        }
        return lists;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
