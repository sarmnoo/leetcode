package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        int[] nums = new int[]{3,1,5,8};
        main.maxCoins(nums);
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] ret = new int[n+2][n+2];
        int[] val = new int[n+2];
        val[0] = val[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i-1];
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i+2; j <= n+1; j++) {
                for(int k = i+1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += ret[i][k] + ret[k][j];
                    ret[i][j] = Math.max(sum, ret[i][j]);
                }
            }
        }
        return ret[0][n+1];
    }
}
