package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] ints = new int[]{7,2,9,3,1};
        int ret = main.rob(ints);
        System.out.println(ret);
    }

    public int rob(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ret[i] = nums[i];
            } else if (i == 1) {
                ret[i] = Math.max(ret[i-1], nums[i]);
            } else {
                ret[i] = Math.max(ret[i-1], ret[i-2] + nums[i]);
            }
        }
        return ret[nums.length-1];
    }
}
