package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

class LevelNode{
    TreeNode node;
    int level;
    public LevelNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
public class Main {


    public static void main(String[] args) {
	// write your code here
    }

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> maxValueLevel = new ArrayList<>();
        if (root == null) {
            return maxValueLevel;
        }
        LinkedBlockingDeque<LevelNode> treeNodes = new LinkedBlockingDeque<>();
        int level = 0;
        treeNodes.add(new LevelNode(root, level));
        while (!treeNodes.isEmpty()) {
            LevelNode cur = treeNodes.poll();
            level = cur.level;
            if (maxValueLevel.size() <= level) {
                maxValueLevel.add(cur.node.val);
            } else {
                if (maxValueLevel.get(level) < cur.node.val) {
                    maxValueLevel.set(level,cur.node.val);
                }
            }
            if (cur.node.left != null) {
                treeNodes.offer(new LevelNode(cur.node.left, cur.level + 1));
            }
            if (cur.node.right != null) {
                treeNodes.offerLast(new LevelNode(cur.node.right,cur.level + 1));
            }
        }
        return maxValueLevel;
    }
}
