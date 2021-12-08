package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int result = main.uniquePaths(0,0);
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {
        int[][] ret = new int[m][n];
        if (m ==0 || n == 0) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            ret[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            ret[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ret[i][j] = ret[i-1][j] + ret[i][j-1];
            }
        }
        return ret[m-1][n-1];
    }

}
