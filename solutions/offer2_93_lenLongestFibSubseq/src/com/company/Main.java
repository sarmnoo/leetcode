package com.company;

import java.util.HashMap;

public class Main {

    public int lenLongestFibSubseq(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        int[][] ret = new int[arr.length][arr.length];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int kValue = arr[i] - arr[j];
                Integer kIndex = indexMap.get(kValue);
                if (kIndex != null && kIndex < j) {
                    ret[i][j] = ret[j][kIndex] + 1;
                } else {
                    ret[i][j] = 2;
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                maxLength = Math.max(maxLength, ret[i][j]);
            }
        }
        if (maxLength == 2)
            return 0;
        return maxLength;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Main main = new Main();
        int i = main.lenLongestFibSubseq(ints);
        System.out.println(i);
    }
}
