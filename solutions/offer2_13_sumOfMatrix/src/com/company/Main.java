package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        int i = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(i);
        int i1 = numMatrix.sumRegion(1, 1, 2, 2);
        System.out.println(i1);
        int i2 = numMatrix.sumRegion(1, 2, 2, 4);
        System.out.println(i2);
    }
}
