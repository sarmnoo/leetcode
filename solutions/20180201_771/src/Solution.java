import java.util.HashMap;
import java.util.Map;

/**
 * Created by ddning on 2018/2/1.
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        int ret = 0;
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();
        for(int i = 0; i < J.length(); i++){
            charMap.put(J.charAt(i),0);
        }
        for(int i = 0; i < S.length(); i++){
            if(charMap.containsKey(S.charAt(i)))
                ret ++;
        }
        return ret;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int ret = s.numJewelsInStones("aSA","aaaSSS");
        System.out.println(ret);
    }
}
