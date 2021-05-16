package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> alpha = new HashMap<>();

        int maxLength = 0;
        int len = 0;
        int begin = 0;
        for (int i = 0 ; i < s.length(); i++) {
            char index = s.charAt(i);
            if (!alpha.containsKey(index)) {
                len ++;
            } else {
                begin = begin < alpha.get(index) ? alpha.get(index) : begin;
                len = i - begin;
            }
            alpha.put(index, i);
            maxLength = maxLength > len? maxLength:len;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "a  b dfjdke fd ";
        Main main = new Main();
        int ret = main.lengthOfLongestSubstring(s);
        System.out.println(ret);
    }
}
