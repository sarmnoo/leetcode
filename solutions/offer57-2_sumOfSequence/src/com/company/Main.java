package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> ret = new ArrayList<>(new ArrayList<>());
        int begin = 1, end = 2;
        int sum = begin + end;
        List<Integer> temp = new ArrayList<>();
        temp.add(begin);
        temp.add(end);
        while(begin < end && end <= target) {
            if (sum < target) {
                end += 1;
                sum += end;
                temp.add(end);
            }
            if (sum > target) {
                sum -= begin;
                temp.remove(0);
                begin += 1;
            }
            if (sum == target && temp.size() > 1) {
                ret.add(new ArrayList<>(temp));
                sum -= begin;
                temp.remove(0);
                begin += 1;
                end += 1;
                sum += end;
                temp.add(end);
            }
        }


        int[][] retArray = new int[ret.size()][];
        for (int i = 0; i < ret.size(); i++) {
            List<Integer> obji = ret.get(i);
            int[] tempArray = new int[obji.size()];
            for (int j = 0; j < obji.size(); j++) {
                tempArray[j] = obji.get(j);
            }
            retArray[i] = tempArray;
        }
        return retArray;
    }

    public static void main(String[] args) {
	// write your code here
        Main solution = new Main();
        int[][] ret = solution.findContinuousSequence(5);
        System.out.println(ret);
    }
}
