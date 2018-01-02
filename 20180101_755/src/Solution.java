/**
 * Created by ddning on 2018/1/1.
 */
public class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for(int w = 0; w < V; w++){
            int tempK = K;
            while(tempK - 1 >= 0 && heights[tempK - 1] <= heights[tempK]){
                tempK -= 1;
            }
            while(tempK < K && heights[tempK] == heights[tempK+1] )
                tempK ++;
            if(tempK != K && heights[tempK] < heights[tempK+1]){
                heights[tempK] ++;
                continue;
            }
            tempK = K;
            while(tempK + 1 < heights.length && heights[tempK + 1] <= heights[tempK]){
                tempK += 1;
            }
            while(tempK > K && heights[tempK] == heights[tempK-1] )
                tempK --;
            if(tempK != K && heights[tempK] < heights[tempK - 1])
                heights[tempK] ++;
            else
                heights[K]++;
        }
        return heights;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] ret = s.pourWater(new int[]{14,9,10,9,7,9,7,5,3,2},7,9);
        for(int i = 0; i < ret.length; i++){
            System.out.print(ret[i]);
        }
    }
}
