import java.util.Stack;

/**
 * Created by ddning on 2017/12/28.
 */
public class Solution {
    public boolean find132pattern(int[] nums){
        Stack<Integer> t = new Stack<Integer>();
        int s3 = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < s3)
                return true;
            else{
                while (!t.empty() && nums[i] > t.peek()){
                    s3 = t.peek();
                    t.pop();
                }
                t.push(nums[i]);
            }
        }
        return false;
    }

}
