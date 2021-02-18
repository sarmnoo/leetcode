import java.util.HashMap;
import java.util.Map;

/**
 * Created by ddning on 2018/1/7.
 */
public class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Integer> bMap = new HashMap<Integer,Integer>();
        int[] ret = new int[A.length];
        for(int i = 0; i < B.length; i++){
            if(!bMap.containsKey(B[i]))
                bMap.put(B[i],i);
        }
        for(int j = 0; j < A.length; j++){
            ret[j] = bMap.get(A[j]);
        }
        return ret;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] ret = s.anagramMappings(new int[]{12, 28, 46, 32, 50},new int[]{50, 12, 32, 46, 28});
        for(int i = 0; i < ret.length; i++){
            System.out.print(ret[i]+" ");
        }
    }
}
