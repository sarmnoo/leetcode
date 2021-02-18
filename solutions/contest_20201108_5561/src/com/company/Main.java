package com.company;

public class Main {

    public int getMaximumGenerated(int n) {
        int max = 0;
        int[] num = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                num[i] = 0;
            } else if (i == 1) {
                num[i] = 1;
            } else if (i % 2 == 0) {
                num[i] = num[i/2];
            } else {
                num[i] = num[i/2] + num[i/2+1];
            }
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
	    Main solution = new Main();
	    int max = solution.getMaximumGenerated(3);
	    System.out.println(max);
    }
}
