package com.company;

public class Main {
    public int firstMissingPositive(int[] nums) {
        int ret = 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[i] != -1) {
                swap(nums, i);
            } else {
                i ++;
            }
        }
        int j = 1;
        for (j = 1; j < nums.length; j++) {
            if (nums[j] != j || nums[j] == -1) {
                ret = j;
                break;
            }
        }
        if (j == nums.length) {
            ret = j;
        }
        return ret;
    }

    public void swap(int[] nums, int i) {
        int cur = nums[i];
        if (cur >= nums.length + 1) {
            nums[i] = -1;
        } else {
            int temp = nums[cur ];
            nums[i] = temp;
            nums[cur] = cur;
        }
        return ;
    }

    public static void main(String[] args) {
	    Main solution = new Main();
	    int[] nums = new int[]{1};
	    int ret = solution.firstMissingPositive(nums);
	    for (int i = 0; i < nums.length; i++){
	        System.out.println(nums[i]);
        }
	    System.out.println(ret);
    }
}
