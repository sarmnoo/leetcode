package com.company;

import java.util.Arrays;

public class Main {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0,len = 0;
        int start = 0, i = 0;
        int[] character = new int[128];
        Arrays.fill(character, -1);
        while(i < s.length()) {
            int index = character[s.charAt(i)];
            if (index != -1 && index >= start){
                start = index + 1;
            } else {
                len = i - start + 1;
                maxLength = len > maxLength ? len:maxLength;
            }
            character[s.charAt(i)] = i;
            i++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int len = main.lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }
}
