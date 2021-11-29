package com.company;

import java.util.*;

/**
 * 利用map和动态数组实现o(1)复杂度的插入、删除、等概率随机获取
 */
public class RandomizedSet {
    private Map<Integer, Integer> num_ind = new HashMap<>();
    private List<Integer> nums = new ArrayList<>();
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (num_ind.containsKey(val)) {
            return false;
        } else {
            nums.add(val);
            num_ind.put(val, nums.size() - 1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (num_ind.containsKey(val)) {
            Integer index = num_ind.get(val);
            Integer lastNum = nums.get(nums.size() - 1);

            nums.set(index, lastNum);
            num_ind.put(lastNum, index);

            num_ind.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }
}
