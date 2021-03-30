import java.util.Stack;

public class Solution {
    public int majorityElement(int[] nums) {
        Stack<Integer> majority = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (majority.isEmpty() || majority.peek() == nums[i]) {
                majority.push(nums[i]);
            } else {
                majority.pop();
            }
        }

        return majority.pop();
    }

    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 3, 3, 3, 5, 4, 2};
        Solution solution = new Solution();
        int ret = solution.majorityElement(nums);
        System.out.println(ret);
    }
}
