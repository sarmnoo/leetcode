package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public String minNumber(int[] nums) {
        PriorityQueue<String> sortStrs = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int i = 0; i < nums.length; i ++) {
            StringBuilder numStr = new StringBuilder();
            if (nums[i] == 0) {
                numStr.append('0');
            } else {
                while(nums[i] != 0) {
                    numStr.append(nums[i] % 10);
                    nums[i] = nums[i] / 10;
                }
            }
            sortStrs.add(numStr.reverse().toString());
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!sortStrs.isEmpty()) {
            stringBuilder.append(sortStrs.poll());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{3,30,34,5,9};
        String retStr = main.minNumber(nums);
        System.out.println(retStr);
    }
}
