package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int ret = 0;
    public static void main(String[] args) {
	// write your code here
    }

    public int pathSum(TreeNode root, int targetSum) {
        //int currentSum = 0;
        List<TreeNode> pathNode = new ArrayList<>();
        dfs(root, targetSum, pathNode);
        return ret;
    }

    public void dfs(TreeNode node, int targetSum, List<TreeNode> pathNode) {
        if (node == null) {
            return ;
        }
        pathNode.add(node);
        if (node.left == null && node.right == null) {
            //叶子节点
            int curSum = 0;
            int begin = 0, index = 0;
            while (index < pathNode.size()) {
                curSum += pathNode.get(index).val;
                while (curSum >= targetSum) {
                    if (curSum == targetSum) {
                        ret ++;
                    }
                    curSum -= pathNode.get(begin).val;
                    begin ++;
                }
                index ++;
            }
        }

        dfs(node.left, targetSum, pathNode);
        pathNode.remove(node.left);
        dfs(node.right, targetSum, pathNode);
    }
}
