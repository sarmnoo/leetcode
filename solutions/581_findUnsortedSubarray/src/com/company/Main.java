package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] ints = new int[]{2,6,4,8,10,9,15};
        int ret = main.findUnsortedSubarray(ints);
        System.out.println(ret);

    }

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;
        int n = nums.length;
        int left = -1, right = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }

            if (nums[n - i - 1] > min) {
                left = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;

    }
}
