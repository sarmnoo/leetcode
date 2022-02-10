package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 利用前缀和计算路径和
 * 记录当前节点之前的前缀和，判断当前节点之前的前缀和是否有 == cur - targetSum；如果有，则ret += 前缀和数量
 * 利用一个map记录前缀和，key为前缀和，value为该前缀和的数量
 */
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        long cur = 0;
        return dfs(prefix, root, cur, targetSum);
    }

    public int dfs (Map<Long, Integer> prefix, TreeNode root, Long cur, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        cur += root.val;
        ret += prefix.getOrDefault(cur - targetSum, 0);
        prefix.put(cur, prefix.getOrDefault(cur,0) + 1);
        ret += dfs(prefix,root.left,cur, targetSum);
        ret += dfs(prefix,root.right,cur, targetSum);
        prefix.put(cur, prefix.getOrDefault(cur,0) - 1);
        return ret;
    }
}
