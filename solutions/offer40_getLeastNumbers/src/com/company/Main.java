package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];

        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            integers.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!integers.isEmpty() && arr[i] < integers.peek()) {
                integers.poll();
                integers.offer(arr[i]);
            }
        }

        int j = 0;
        while (!integers.isEmpty()) {
            ret[j++] = integers.poll();
        }
        return ret;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,4,3,6,7,8,0};
        Main solution = new Main();
        int[] ret = solution.getLeastNumbers(arr, 0);
        for (int i =0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
        //System.out.println(ret);
    }
}
