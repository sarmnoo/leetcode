package com.company;

public class Main {

    public int maxValue(int[][] grid) {
        int ret[][] = new int[grid.length][grid[0].length];
        ret[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            ret[0][i] = ret[0][i-1] + grid[0][i];
        }
        for (int j = 1; j < grid.length; j++) {
            ret[j][0] = ret[j-1][0] + grid[j][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j ++) {
                ret[i][j] = Math.max(ret[i-1][j], ret[i][j-1]) + grid[i][j];
            }
        }
        return ret[grid.length-1][grid[0].length - 1];
    }

    public static void main(String[] args) {
	// write your code here
    }
}
