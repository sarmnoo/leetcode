import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ddning on 04/04/2018.
 */
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> ret = new HashMap<String,Integer>();
        for(int i = 0; i < cpdomains.length; i++){
            int count = Integer.parseInt(cpdomains[i].split(" ")[0]);
            String domain = cpdomains[i].split(" ")[1];
            if(!ret.containsKey(domain)){
                ret.put(domain,count);
            }
            else{
                int temp = ret.get(domain);
                ret.put(domain,temp+count);
            }

            for(int j = 0; j < domain.length(); j++){
                if(domain.charAt(j) == '.'){
                    String key = domain.substring(j+1);
                    if(!ret.containsKey(key)){
                        ret.put(key,count);
                    }
                    else{
                        int temp = ret.get(key);
                        ret.put(key,temp+count);
                    }
                }
            }
        }

        List<String> retList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:ret.entrySet()){
            String temp = entry.getValue().toString()+" "+entry.getKey();
            retList.add(temp);
        }
        return retList;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        String[] domains = new String[]{"9001 discuss.leetcode.com"};
        List<String> ret = s.subdomainVisits(domains);
        for(String str:ret){
            System.out.println(str);
        }
    }
}
