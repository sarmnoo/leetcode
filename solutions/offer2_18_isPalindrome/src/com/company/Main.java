package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        boolean ret = main.isPalindrome("a");
        System.out.println(ret);
    }

    public boolean isPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        while(begin < end) {
            if (isAlphaOrNum(s.charAt(begin)) && isAlphaOrNum(s.charAt(end))) {
                if (Character.toLowerCase(s.charAt(begin)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                begin ++;
                end --;
                continue;
            }
            if (!isAlphaOrNum(s.charAt(begin))) {
                begin ++;
            }
            if (!isAlphaOrNum(s.charAt(end))){
                end --;
            }
        }
        return true;
    }
    public boolean isAlphaOrNum(char c) {
        return Character.isLetterOrDigit(c);
    }
}
