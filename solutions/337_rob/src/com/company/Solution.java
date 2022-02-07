package com.company;

public class Solution {
    /**
     * 动态规划：
     * 对每个节点进行计算：偷该节点、不偷该节点两种情况进行比较。
     * 如果偷当前节点：则不能偷其左右节点；
     * 如果不偷当前节点：左右节点可以偷也可以不偷，取大。
     * 对于每个节点，计算数组ret[0,1],ret[0]表示偷该节点的最大值，ret[1]表示不偷该节点
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] ret = dfs(root);
        return Math.max(ret[0], ret[1]);
    }

    //后序遍历，先计算左节点和右节点，再计算根节点。
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0,0};
        }

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int[] cur = new int[]{0,0};
        //偷该节点,不偷其左右节点
        cur[0] = node.val + l[1] + r[1];
        //不偷该节点
        cur[1] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return cur;
    }

    public static void main(String[] args) {

    }
}
