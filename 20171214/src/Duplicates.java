import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddning on 2017/12/14.
 */
public class Duplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -Math.abs(nums[index]);
            }
            else{
                ret.add(Math.abs(index + 1));
            }
        }
        return ret;
    }

    public static void main(String[] args){
        Duplicates s = new Duplicates();
        List<Integer> ret = s.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        for(int i = 0; i < ret.size(); i++){
            System.out.print(ret.get(i)+" ");
        }
    }
}
