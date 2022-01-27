package com.company;

public class Main {

    int ret = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int currentSum = 0;
        dfs(nums, target, 0, currentSum);
        return ret;
    }

    public void dfs(int[] nums, int target, int index, int sum) {
        if (index >= nums.length) {
            if (target == sum) {
                ret ++;
            }
            return ;
        }
        dfs(nums, target, index + 1, sum + nums[index]);
        dfs(nums, target, index + 1, sum - nums[index]);
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1,1,1,1,1};
        int ret = main.findTargetSumWays(nums, 3);
        System.out.println(ret);
    }
}
