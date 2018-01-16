import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ddning on 2018/1/4.
 */
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    class Compare implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start == o2.start)
                return (o1.end - o2.end);
            return (o1.start - o2.start);
        }
    }
    class Compare_end implements Comparator<Interval>{
        @Override
        public int compare(Interval o1,Interval o2){
            if(o1.end == o2.end)
                return (o1.start - o2.start);
            return (o1.end - o2.end);
        }
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        Compare cmp = new Compare();
        Compare_end cmp_end = new Compare_end();
        Arrays.sort(intervals,cmp);
        int remove_start = getRemoveNum(intervals);
        Arrays.sort(intervals,cmp_end);
        int remove_end = getRemoveNum(intervals);
        return remove_end < remove_start?remove_end:remove_start;
    }
    public int getRemoveNum(Interval[] intervals){
        int remove = 0;
        List<Integer> removeList = new ArrayList<>();
        for(int i = 0; i < intervals.length - 1; i++){
            int j = i + 1;
            while(!removeList.contains(i) && j < intervals.length && intervals[i].end > intervals[j].start){
                remove ++;
                removeList.add(j);
                j ++;
            }
        }
        return remove;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int remove = s.eraseOverlapIntervals(new Interval[]{new Interval(1,2),new Interval(2,3)});
        System.out.println(remove);
    }
}
