import java.util.HashMap;
import java.util.Map;

/**
 * Created by ddning on 2018/1/17.
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int ret = 0;
        int[] sum = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0)
                sum[i] = nums[i];
            else{
                sum[i] = sum[i-1] + nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(sum[j] - sum[i] + nums[i] == k)
                    ret ++;
            }
        }
        return ret;
    }

        public int subarraySum2(int[] nums, int k) {
            int sum = 0, result = 0;
            Map<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0, 1);

            for (int num : nums) {
                sum += num;
                result += preSum.getOrDefault(sum - k, 0);
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }
            return result;
        }

    public static void main(String[] args){
        Solution s = new Solution();
        int ret = s.subarraySum2(new int[]{1,1,1},2);
        System.out.println(ret);
    }
}
