package com.company;

import java.util.Arrays;
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

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args) {
//        String s = "a  b dfjdke fd ";
//        Main main = new Main();
//        int ret = main.lengthOfLongestSubstring(s);
//        System.out.println(ret);
        int a1 = 2, b = 3;
        Main main = new Main();
        main.swap(a1,b);
        System.out.println(a1);
        System.out.println(b);

//        int[] a = {4,1,5,2,3,9,10,6};
//
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length-1-i; j++) {
//                if (a[j] > a[j+1]) {
//                    int temp = a[j+1];
//                    a[j+1] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(a));
        Person person = new Person("hhh",6);
        System.out.println(person.getAge());

    }
}
