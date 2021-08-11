package com.company;

public class Main {

//    public static int search(int[] nums, int target) {
//        int leftIdx = binarySearch(nums, target, true);
//        int rightIdx = binarySearch(nums, target, false) - 1;
//        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
//            return rightIdx - leftIdx + 1;
//        }
//        return 0;
//    }
//
    public static int binarySearch(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length - 1;
        int mid = 0, ans = nums.length;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target || (nums[mid] == target && isLeft)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false)-1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx+1;
        }
        return 0;
    }

//    public static int binarySearch(int[] nums, int target, boolean lower) {
//        int left = 0, right = nums.length - 1, ans = nums.length;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] > target || (lower && nums[mid] >= target)) {
//                right = mid - 1;
//                ans = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
//    }



    public static void main(String[] args) {
	    int[] nums = new int[]{1,2,3,4,5,6,7,8,8,9};
	    int ret = search(nums, 8);
        System.out.println(ret);

    }
}
