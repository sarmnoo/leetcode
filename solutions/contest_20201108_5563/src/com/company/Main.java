package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> value = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < inventory.length; i ++) {
            value.offer(inventory[i]);
        }

        int maxValue = 0;
        while(!value.isEmpty() && orders != 0){
            int temp = value.poll();
            maxValue += temp;
            value.offer(temp - 1);
            orders --;
        }
        return maxValue;
    }



    public static void main(String[] args) {
	    Main solution = new Main();
	    int[] inventory = new int[]{2,8,4,10,6};
	    int orders = 20;
	    int maxValue = solution.maxProfit(inventory, orders);
	    System.out.print(maxValue);

    }
}
