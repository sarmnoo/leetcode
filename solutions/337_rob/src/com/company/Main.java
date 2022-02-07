package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        TreeNode root = new TreeNode(2);
        int a = main.rob(root);
        System.out.println(a);
    }

    /**
     * 错误：未考虑2，1，3，null,4这种情况
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> levelNum = new ArrayList<>();
        levelScan(root,levelNum);
//        Integer[] temp = new Integer[]{3,4,200,100};
//        levelNum = Arrays.asList(temp);

        int[] ret = new int[levelNum.size()];
        for (int i = 0; i < levelNum.size(); i++) {
            if (i - 1 < 0) {
                ret[i] = levelNum.get(i);
            } else if (i - 2 < 0) {
                ret[i] = Math.max(ret[i - 1], levelNum.get(i));
            } else{
                ret[i] = Math.max(ret[i - 1], ret[i - 2] + levelNum.get(i));
            }
        }
        return ret[ret.length - 1];
    }

    public void levelScan(TreeNode root, List<Integer> levelNum) {
        Queue<TreeNode> nodes = new LinkedBlockingQueue<>();
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            int curSize = nodes.size();
            int curSum = 0;
            for (int i = 0; i < curSize; i++) {
                TreeNode poll = nodes.poll();
                curSum += poll.val;
                if (poll.left != null) nodes.offer(poll.left);
                if (poll.right != null) nodes.offer(poll.right);
            }
            levelNum.add(curSum);
        }
    }

}
