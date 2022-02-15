package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int maxProduct(int[] nums) {
        int[] maxArray = new int[nums.length];
        int[] minArray = new int[nums.length];
        maxArray[0] = minArray[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxArray[i] = Math.max(Math.max(maxArray[i-1] * nums[i], minArray[i-1] * nums[i]), nums[i]);
            minArray[i] = Math.min(Math.min(maxArray[i-1] * nums[i], minArray[i-1] * nums[i]), nums[i]);

        }
        int ret = maxArray[0];
        for (int i = 1; i < maxArray.length; i++) {
            if (maxArray[i] > ret) {
                ret = maxArray[i];
            }
        }
        return ret;
    }
}
