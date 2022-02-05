package com.ddning;

import apple.laf.JRSUIUtils;

public class Solution {
    TreeNode root = null;
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        root = dfs(root1, root);
        root = dfs(root2, root);
        return root;
    }

    public TreeNode dfs(TreeNode node, TreeNode root) {
        if (node == null) {
            return root;
        }
        if (root == null) {
            root = new TreeNode(node.val);
        } else {
            root.val += node.val;
        }
        root.left = dfs(node.left, root.left);
        root.right = dfs(node.right, root.right);
        return root;
    }
}
