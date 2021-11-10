package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{0};
        int maxLength = main.findMaxLength(nums);
        System.out.println(maxLength);

    }

    public int findMaxLength(int[] nums) {
        int[] temp = nums;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                temp[i] = -1;
            }
        }

        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < temp.length; i++) {
            sum += temp[i];
            if (sum == 0) {
                maxLength = i + 1;
            }
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum,i);
            }

            if (sumMap.containsKey(sum)) {
                int len = i - sumMap.get(sum);
                maxLength = maxLength > len ? maxLength:len;
            }
        }
        return maxLength;

    }


}
