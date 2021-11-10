package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumMatrix {
    private List<Map<Integer, Integer>> matrixSumMap = new ArrayList<Map<Integer, Integer>>();
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int rowSum;
        for (int i = 0; i < row; i ++) {
            HashMap<Integer, Integer> rowMap = new HashMap<>();
            rowSum = 0;
            for (int j = 0; j < col; j++) {
                rowSum += matrix[i][j];
                rowMap.put(j,rowSum);
            }
            matrixSumMap.add(rowMap);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumRegin = 0;
        int rowSum = 0;
        for (int i = row1; i <= row2; i++) {
            Map<Integer, Integer> rowMap = matrixSumMap.get(i);
            if (col1 == 0) {
                rowSum = rowMap.get(col2);
            } else {
                rowSum = rowMap.get(col2) - rowMap.get(col1-1);
            }
            sumRegin += rowSum;
        }
        return sumRegin;
    }

}
