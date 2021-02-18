import com.sun.xml.internal.ws.util.QNameMap;

import java.util.*;

/**
 * Created by ddning on 2017/12/25.
 */
public class Solution {
    class Compare implements Comparator<Map.Entry<Character,Integer>>{

        @Override
        public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2){
            return (o2.getValue() - o1.getValue());
        }
    }
    public String frequencySort(String s) {
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            if(charMap.containsKey(key)){
                charMap.put(key,charMap.get(key)+1);
            }
            else{
                charMap.put(key,1);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Character>[] bucket = new ArrayList[s.length() +1];
        for(char key:charMap.keySet()){
            int frequent = charMap.get(key);
            if(bucket[frequent] == null){
                bucket[frequent] = new ArrayList<>();
            }
            bucket[frequent].add(key);
        }
        for(int j = bucket.length-1; j > 0; j--){
            if(bucket[j] != null){
                for(char key:bucket[j]){
                    for(int k = 0; k < charMap.get(key); k++)
                        sb.append(key);
                }
            }

        }

//        Compare cmp = new Compare();
//        List<Map.Entry<Character,Integer>> maplist = new ArrayList<>(charMap.entrySet());
//        Collections.sort(maplist,cmp);
//        String ret = "";
//        for(Map.Entry<Character,Integer> ety:maplist){
//            for(int i = 0; i < ety.getValue(); i++){
//                ret += ety.getKey();
//            }
//        }
        return sb.toString();

    }

    public static void main(String[] args){
        Solution s = new Solution();
        String ret = s.frequencySort("lllaaaadA");
        System.out.print(ret);
    }
}
