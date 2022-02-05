package com.company;

public class Main {
    int ret = 0;
    public static void main(String[] args) {
	// write your code here
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ret - 1;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = dfs(node.left);
        int R = dfs(node.right);
        ret = Math.max(ret, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
