import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddning on 2018/3/11.
 */
public class Solution {
    public boolean rotateString(String A, String B) {
        if(B.length() != A.length())
            return false;
        List<Integer> begin = new ArrayList<Integer>();
        for(int i = 0; i < B.length(); i++){
            if(B.charAt(i) == A.charAt(0)){
                begin.add(i);
            }
        }
        if(begin.isEmpty())
            return false;
        for(int j = 0; j < begin.size(); j++){
            int k = 0;
            for(int i = begin.get(j); k < B.length(); k++){
                if(B.charAt((i+k)%B.length()) != A.charAt(k)){
                    break;
                }
            }
            if(k == B.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        boolean ret = s.rotateString("bqqutquvbtgouklsayfvzewpnrbwfcdmwctusunasdbpbmhnvy",
                "wpnrbwfcdmwctusunasdbpbmhnvybqqutquvbtgouklsayfvze");
        System.out.println(ret);
    }
}
