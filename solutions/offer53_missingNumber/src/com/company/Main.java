package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[]{0,1,2,3,4,5,6,8};
        int ret = missingNumber(nums);
        System.out.println(ret);
    }

    public static int missingNumber(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == left) {
            return left + 1;
        }
        return left;
    }




}
