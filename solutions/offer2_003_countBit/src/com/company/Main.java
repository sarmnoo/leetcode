package com.company;

public class Main {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int current = i;
            int j = 0;
            while(current > 0) {
                current = current & (current-1);
                j ++;
            }
            ret[i] = j;
        }
        return ret;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] ret = main.countBits(3);
        for (int i : ret) {
            System.out.println(i);
        }
    }
}
