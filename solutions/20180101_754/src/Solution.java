import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ddning on 2018/1/1.
 */
public class Solution {
    public int reachNumber(int target) {
        int temp = 0;
        target = Math.abs(target);
        for(int i = 1; ;i++){
            if(temp + i == target)
                return i;
            if(temp + i > target){
                if((temp + i - target) % 2 == 0)
                    return i;
                else
                    temp += i;
            }
            else{
                temp += i;
            }
        }
    }


    public static void main(String[] args){
        Solution s = new Solution();
        int ret = s.reachNumber(-100000000);
        System.out.println(ret);
    }

}
