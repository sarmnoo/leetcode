public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int avg = 0,temp = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1)
            return false;
        else {
            avg = sum / 2;
            return add(nums, 0, temp, avg, 0) || add(nums, 0, temp, avg, 1);
        }
    }
    public boolean add(int[] nums, int i, int temp, int avg, int flag){
        if(i >= nums.length)
            return false;
        if(flag == 1){
            temp += nums[i];
        }
        if(temp > avg)
            return false;
        if(temp == avg)
            return true;
        else{
            return add(nums,i+1,temp,avg,0) || add(nums,i+1,temp,avg,1);
        }
    }

    //solution2 0/1背包问题
    public boolean canPartition2(int[] nums){

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,5,11,5,3,3,7,8,9,10,2,3,5,4,7,8,1};
        boolean ret = s.canPartition(nums);
        System.out.print(ret);
    }
}
