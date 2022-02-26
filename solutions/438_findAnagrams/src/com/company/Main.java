package com.company;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        List<Integer> ret = main.findAnagrams("cbaebabacb", "abc");
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if (s.length() < p.length()) {
            return ret;
        }

        int[] scount = new int[26];
        int[] pcount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            scount[s.charAt(i) - 'a'] ++;
            pcount[p.charAt(i) - 'a'] ++;
        }

        if (Arrays.equals(scount, pcount)) {
            ret.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i ++) {
            scount[s.charAt(i) - 'a'] --;
            scount[s.charAt(i + p.length()) - 'a'] ++;

            if (Arrays.equals(scount, pcount)) {
                ret.add(i+1);
            }
        }
        return ret;
    }

}
