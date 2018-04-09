/**
 * Created by ddning on 2018/3/7.
 */
public class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int num = 0;
        boolean isSubseq = false;
        for(int i = 0; i < words.length; i++){
            isSubseq = isSubsequence(S,words[i]);
            if(isSubseq)
                num ++;
        }
        return num;
    }

    public boolean isSubsequence(String S,String temp){
        int i = 0;
        int j = 0;
        while(j < S.length()){
            if(S.charAt(j) == temp.charAt(i)){
                i++;
                j++;
                if(i == temp.length())
                    return true;
            }
            else{
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        int num = s.numMatchingSubseq("abcde",words);
        System.out.println(num);
    }
}
