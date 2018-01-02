import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ddning on 2017/10/17.
 */
public class LongestPalindrome {
    public int longest(String s){
        int longestLength = 0;

        Map<Character,Integer> chMap = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            if(chMap.containsKey(s.charAt(i))){
                chMap.put(s.charAt(i),(Integer)(chMap.get(s.charAt(i)) + 1));
            }
            else{
                chMap.put(s.charAt(i),1);
            }
        }
        int odd = 0;
        Set<Character> key = chMap.keySet();
        char maxChar = ' ';
        for(Character ch:key){
            if(chMap.get(ch) % 2 == 0){
                longestLength += chMap.get(ch);
            }
            else{
                if(chMap.get(ch) > odd){
                    odd = chMap.get(ch);
                    maxChar = ch;
                }
            }
        }
        for(Character ch:key){
            if(chMap.get(ch) % 2 != 0 && chMap.get(ch) <= odd && maxChar != ' ' && ch != maxChar){
                longestLength += chMap.get(ch) - 1;
            }
        }
        return longestLength + odd;
    }

    public static void main(String[] args){
        LongestPalindrome pro = new LongestPalindrome();
        int ret = pro.longest("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        System.out.println(ret);
    }
}
