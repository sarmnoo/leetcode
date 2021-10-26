package com.company;

public class Main {

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int minSubArrayLen = nums.length;
        boolean isHave = false;

        while (start <= end && end < nums.length) {
            if (sum < target) {
                sum += nums[end];
                end ++;
            }
            while (sum >= target && start <= end) {
                if (end-start <= minSubArrayLen) {
                    minSubArrayLen = end - start;
                    isHave = true;
//                    if (minSubArrayLen == 1){
//                        break;
//                    }
                }
                sum -= nums[start++];
            }
        }
        if (!isHave) {
            return 0;
        }
        return minSubArrayLen;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;
        int ret = main.minSubArrayLen(target, nums);
        System.out.println(ret);
    }
}
