//import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

/**
 * Created by ddning on 2018/1/2.
 */

class Compare implements Comparator<Map.Entry<Interval,Integer>>{
    @Override
    public int compare(Map.Entry<Interval,Integer> o1,Map.Entry<Interval,Integer> o2){
        if(o1.getKey().start == o2.getKey().start)
            return (o1.getKey().end - o2.getKey().end);
        return o1.getKey().start - o2.getKey().start;
    }

}

public class Solution {

    public int[] findRightInterval(Interval[] intervals) {
        int[] ret = new int[intervals.length];
        Map<Interval,Integer> intervalMap = new HashMap<>();
        for(int i = 0; i < intervals.length; i++){
            intervalMap.put(intervals[i],i);
        }
        Compare cmp = new Compare();
        List<Map.Entry<Interval,Integer>> entryList = new ArrayList(intervalMap.entrySet());
        Collections.sort(entryList,cmp);
        for(int i = 0; i < entryList.size()-1; i++){
            int temp = i+1;
            int beforeEnd = entryList.get(i).getKey().end;
            while(temp < entryList.size()){
                if(entryList.get(temp).getKey().start >= beforeEnd){
                    ret[entryList.get(i).getValue()] = entryList.get(temp).getValue();
                    break;
                }
                temp ++;
            }
            if(temp == entryList.size())
                ret[entryList.get(i).getValue()] = -1;
        }
        ret[entryList.get(ret.length - 1).getValue()] = -1;
        return ret;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        Interval[] intervals = new Interval[]{new Interval(1,2)};
        int[] ret = s.findRightInterval(intervals);
        for(int i = 0; i < ret.length; i++){
            System.out.print(ret[i]+" ");
        }
    }
}
