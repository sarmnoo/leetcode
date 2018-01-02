import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ddning on 2017/12/30.
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1]?(o1[0] - o2[0]):(o1[1] - o2[1]);
            }
        });
        int arrow = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < points.length; i++){
            if(arrow != Integer.MIN_VALUE && arrow >= points[i][0])
                continue;
            count ++;
            arrow = points[i][1];
        }
        return count;
    }
    public static void main(String[] args){
        Solution s = new Solution();

        int count = s.findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}});
        System.out.print(count);
    }
}
