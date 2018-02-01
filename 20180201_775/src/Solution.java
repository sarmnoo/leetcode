import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ddning on 2018/2/1.
 */
public class Solution {
    public boolean isIdealPermutation(int[] A) {
        Map<Integer,Integer> arrayMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < A.length; i++){
            arrayMap.put(A[i],i);
        }
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(Math.abs(arrayMap.get(A[i]) - i) > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        boolean ret = s.isIdealPermutation(new int[]{});
        System.out.println(ret);
    }
}
