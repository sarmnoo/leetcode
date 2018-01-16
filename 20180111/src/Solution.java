/**
 * Created by ddning on 2018/1/11.
 */
public class Solution {
    public int countSegments(String s) {
        int ret = 0;
        if(s.length() == 0)
            return 0;
        int indx = -1;
        int begin = 0;
        int end = s.length() - 1;
        while (begin < s.length() && s.charAt(begin) == ' '){
            begin++;
        }
        while (end >= 0 && s.charAt(end) == ' '){
            end --;
        }
        if(begin > end)
            ret = -1;
        for(int i = begin; i <= end; i++){
            if(s.charAt(i) == ' ' ){
                if(i != indx+1)
                    ret ++;
                indx = i;
            }
        }
        return ret+1;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int ret = s.countSegments("a b c");
    }

}
