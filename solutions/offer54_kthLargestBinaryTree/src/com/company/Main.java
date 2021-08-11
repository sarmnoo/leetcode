package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    private int ret = 0;
    private int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ret;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.right);
            if (k == 0) return;
            if (--k == 0) {
                ret = root.val;
            }
            dfs(root.left);
        }
    }
}
