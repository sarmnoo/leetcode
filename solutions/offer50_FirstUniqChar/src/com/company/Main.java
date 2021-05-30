package com.company;

public class Main {

    public char firstUniqChar(String s) {
        int[] character = new int[255];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - ' ';
            if (character[index] == 0) {
                character[index] = 1;
            } else {
                character[index] = -1;
            }
        }

        for (int j = 0; j < s.length(); j++) {
            int index = s.charAt(j) - ' ';
            if (character[index] == 1) {
                return s.charAt(j);
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        Main main = new Main();
        char ret = main.firstUniqChar(" abcd");
        System.out.println(ret);

    }

}
