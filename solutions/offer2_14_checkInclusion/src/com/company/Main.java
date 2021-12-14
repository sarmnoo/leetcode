package com.company;

import java.util.Arrays;

public class Main {

    public boolean checkInclusion(String s1, String s2) {
        int[] character = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            character[s1.charAt(i) - 'a'] += 1;
        }

        int[] temp = Arrays.copyOf(character, character.length);
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (temp[s2.charAt(i) - 'a'] > 0) {
                temp[s2.charAt(i) - 'a'] --;
                count ++;
                if (count == s1.length()) {
                    return true;
                }
            } else {
                temp = Arrays.copyOf(character, character.length);
                count = 0;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        Main main = new Main();
        System.out.println(main.checkInclusion(s1, s2));
    }
}
