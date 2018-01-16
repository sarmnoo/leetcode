import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ddning on 2018/1/14.
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        boolean charMap[] = new boolean[26];
        int i = 0,end = 0,begin = 0;
        while(i < S.length() && end < S.length() && begin < S.length()){
            while(i <= end){
                char cur = S.charAt(i);
                if(charMap[cur - 'a'] == false){
                    for(int j = S.length()-1; j > end;j--){
                        if(S.charAt(j) == cur){
                            end = j;
                        }
                    }
                }
                i++;
            }
            if(end - begin + 1 > 0){
                ret.add(end-begin+1);
                end = i;
                begin = i;
            }
        }
        return ret;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        List<Integer> ret = s.partitionLabels("");
        for(Integer in:ret){
            System.out.print(in+" ");
        }
    }
}
