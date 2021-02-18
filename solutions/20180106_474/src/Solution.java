import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ddning on 2018/1/6.
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int nums[][] = new int[strs.length][];
        for(int i = 0; i < strs.length; i++){
            int zero = 0,one = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0')
                    zero ++;
                else
                    one ++;
            }
            nums[i] = new int[]{zero,one};
        }
        int ret[][] = new int[m+1][n+1];

        for(int i = 0; i < strs.length; i++){
            for(int j = m; j >= nums[i][0]; j--){
                for(int k = n; k >= nums[i][1]; k--){
                    ret[j][k] = Math.max(ret[j][k],ret[j-nums[i][0]][k-nums[i][1]]+1);
                }
            }
        }
        return ret[m][n];
    }

    public int getNum(int[][] nums, int m,int n){
        int temp_zero = m, temp_ones = n;
        int ret  = 0;
        for(int i = 0; i < nums.length; i++){
            if(temp_zero >= nums[i][0] && temp_ones >= nums[i][1]){
                temp_zero -= nums[i][0];
                temp_ones -= nums[i][1];
                ret ++;
            }
            else
                break;
        }
        return ret;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int ret = s.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3);
        System.out.println(ret);
    }
}
