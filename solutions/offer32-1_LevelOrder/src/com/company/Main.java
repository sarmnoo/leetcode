package com.company;

import apple.laf.JRSUIUtils;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> nodeValues = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedBlockingQueue<>();
        if (root == null) {
            return new int[]{};
        }
        treeNodes.offer(root);
        while(!treeNodes.isEmpty()) {
            TreeNode topNode = treeNodes.poll();
            nodeValues.add(topNode.val);
            if (topNode.left != null) {
                treeNodes.offer(topNode.left);
            }
            if (topNode.right != null) {
                treeNodes.offer(topNode.right);
            }
        }

        int len = nodeValues.size();
        Integer[] array = nodeValues.toArray(new Integer[nodeValues.size()]);

        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i ++) {
            ret[i] = array[i];
        }
        return ret;

    }

    public static void main(String[] args) {
	// write your code here
    }
}
