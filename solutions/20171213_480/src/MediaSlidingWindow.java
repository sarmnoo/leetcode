import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ddning on 2017/12/13.
 */
public class MediaSlidingWindow {
    class Compare implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return (b - a);
        }
    }
    class Compare1 implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return (a - b);
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        Compare cmp = new Compare();
        Compare1 cmpTemp = new Compare1();
        PriorityQueue<Integer> q = new PriorityQueue<>(cmp);
        PriorityQueue<Integer> tmp = new PriorityQueue<>(cmpTemp);
        double[] ret = new double[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            if(q.size() < k){
                q.add(nums[i]);
            }
            else if(q.size() == k){
                if(k % 2 == 1){
                    for(int j = 0; j < k/2; j++)
                        tmp.add(q.poll());
                    ret[i - k] = q.peek();
                    for(int m = 0; m < k/2; m++){
                        q.add(tmp.poll());
                    }
                    q.remove(nums[i - k]);
                    q.add(nums[i]);
                }else{
                    for(int j = 0; j < k/2; j++){
                        tmp.add(q.poll());
                    }
                    long left = tmp.peek();
                    long right = q.peek();
                    ret[i - k] = (left + right)/2.0;
                    for(int m = 0; m < k/2; m++){
                        q.add(tmp.poll());
                    }
                    q.remove(nums[i - k]);
                    q.add(nums[i]);
                }
            }
        }
        if(k % 2 == 1){
            for(int j = 0; j < k/2; j++)
                tmp.add(q.poll());
            ret[nums.length - k] = q.peek();
        }else {
            for (int j = 0; j < k/2; j++) {
                tmp.add(q.poll());
            }
            long left = tmp.peek();
            long right = q.peek();
            ret[nums.length - k] =  (left + right) / 2.0;
        }
        return ret;
    }

    public static void main(String[] args){
        MediaSlidingWindow s = new MediaSlidingWindow();
        double[] ret = s.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},4);
        for(double i:ret){
            System.out.print(i+" ");
        }
    }
}
