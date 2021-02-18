import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ddning on 2018/1/7.
 */
public class Solution {
    class Compare implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start == o2.start)
                return (o1.end - o2.end);
            return o1.start - o2.start;
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ret = new ArrayList<>();
        List<Interval> temp = new ArrayList<>();
        for(List<Interval> sche:schedule){
            for(Interval inte:sche){
                temp.add(inte);
            }
        }
        Compare cmp = new Compare();
        Collections.sort(temp,cmp);
        int end = temp.get(0).end;
        for(int i = 0; i < temp.size()-1; i++){
            int aStart = temp.get(i).start;
            int aEnd = temp.get(i).end;
            int bStart = temp.get(i+1).start;
            int bEnd = temp.get(i+1).end;
            if(bStart > end){
                ret.add(new Interval(end,bStart));
            }
            end = end > bEnd?end:bEnd;
        }
        return ret;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<List<Interval>> test = new ArrayList<List<Interval>>();
        List<Interval> temp = new ArrayList<Interval>();
        temp.add(new Interval(7,24));
        temp.add(new Interval(94,99));
        temp.add(new Interval(29,33));
        temp.add(new Interval(45,57));
        temp.add(new Interval(66,69));
        test.add(temp);
        List<Interval> temp2 = new ArrayList<Interval>();
        temp2.add(new Interval(6,24));
        temp2.add(new Interval(43,49));
        temp2.add(new Interval(56,59));
        temp2.add(new Interval(61,75));
        temp2.add(new Interval(80,81));
        test.add(temp2);
        List<Interval> temp3 = new ArrayList<Interval>();
        temp3.add(new Interval(5,16));
        temp3.add(new Interval(18,26));
        temp3.add(new Interval(33,36));
        temp3.add(new Interval(39,57));
        temp3.add(new Interval(65,74));
        test.add(temp3);
        List<Interval> temp4 = new ArrayList<Interval>();
        temp4.add(new Interval(9,16));
        temp4.add(new Interval(27,35));
        temp4.add(new Interval(40,55));
        temp4.add(new Interval(68,71));
        temp4.add(new Interval(78,81));
        test.add(temp4);
        List<Interval> temp5 = new ArrayList<Interval>();
        temp5.add(new Interval(0,25));
        temp5.add(new Interval(29,31));
        temp5.add(new Interval(40,47));
        temp5.add(new Interval(57,87));
        temp5.add(new Interval(91,94));
        test.add(temp5);
        List<Interval> ret = s.employeeFreeTime(test);
    }
}
