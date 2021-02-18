/**
 * Created by ddning on 2018/1/21.
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int index = 0;
        int maxIndex = 0;
        int ret = 0;
        while(index < arr.length){
            while(index <= maxIndex){
                for(int i = arr.length-1; i > maxIndex; i--){
                    if(arr[i] < arr[index]){
                        maxIndex = i;
                        break;
                    }
                }
                index ++;
            }
            ret ++;
            maxIndex = index;
        }
        return ret;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int ret = s.maxChunksToSorted(new int[]{2,2,2,5,4,3});
        System.out.print(ret);
    }
}
