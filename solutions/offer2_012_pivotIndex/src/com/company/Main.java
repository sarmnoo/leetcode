package com.company;

public class Main {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == leftSum * 2) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] ints = {1,2,3,4,-1,-2,8,1};
        int ret = main.pivotIndex(ints);
        System.out.println(ret);
    }
}
