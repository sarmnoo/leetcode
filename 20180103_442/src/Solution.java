import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddning on 2018/1/3.
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[nums[i] - 1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1)
                ret.add(i+1);
        }

        return ret;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<Integer> ret = s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for(Integer i:ret)
            System.out.print(i+" ");
    }
}
