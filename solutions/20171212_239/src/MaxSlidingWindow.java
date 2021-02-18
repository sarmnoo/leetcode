import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ddning on 2017/12/12.
 */
public class MaxSlidingWindow {
    class Compare implements Comparator<Integer>{

        @Override
        public int compare(Integer a, Integer b){
            return (b - a);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[]{};
        int[] result = new int[nums.length - k+1];
        Compare cmp = new Compare();
        PriorityQueue<Integer> q = new PriorityQueue<>(cmp);
        for(int i = 0; i < nums.length; i++){
            if(q.size() < k){
                q.add(nums[i]);
            }
            else if(q.size() == k){
                result[i-k] = q.peek();
                q.remove(nums[i-k]);
                q.add(nums[i]);
            }
        }
        result[nums.length - k] = q.peek();
        return result;
    }

    public static void main(String[] args){
        MaxSlidingWindow s = new MaxSlidingWindow();
        int[] ret = s.maxSlidingWindow(new int[]{5,2,3,4},4);
        for(int i:ret){
            System.out.print(i+" ");
        }
    }
}
