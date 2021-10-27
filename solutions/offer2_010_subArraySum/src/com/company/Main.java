package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer > preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int sum = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
//            if (preSumMap.containsKey(sum - k)) {
//                ret += preSumMap.get(sum - k);
//            }
//            Integer value = preSumMap.get(sum);
//            if (value == null) {
//                value = 0;
//            }
//            value += 1;
//            preSumMap.put(sum, value);

            ret += preSumMap.getOrDefault(sum - k, 0);
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);

        }
        return ret;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1,2,3};
        int k = 3;
        System.out.println(main.subarraySum(nums, k));
    }
}
