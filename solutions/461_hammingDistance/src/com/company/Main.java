package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        int i = main.hammingDistance(1, 4);
        System.out.println(i);
        //001
        //100
    }

    public int hammingDistance(int x, int y) {
        int ret = 0;
        int a = x ^ y;
        int i = 1;
        while (a != 0) {
            ret += a & 1;
            a = a >> 1;
        }
        return ret;
    }

}
