package com.company;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        int[] maxValue = new int[nums.length - k + 1];
        int i = 0;
        for (int num : nums) {
            if (queue.size() >= k) {
                maxValue[i++] = deque.peekFirst();
                int top = queue.poll();
                if (top == deque.peekFirst()) {
                    deque.pollFirst();
                }
            }
            queue.offer(num);
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.offerLast(num);
        }
        maxValue[i] = deque.pollFirst();

        return maxValue;
    }

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder ret = new StringBuilder();
        for (int i = strs.length-1; i >= 0; i--) {
            if (!strs[i].equals("")) {
                ret.append(strs[i]).append(" ");
            }


        }
        String retStr = ret.toString().trim();
        return retStr;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
//        Main m = new Main();
//        int[] ret = m.maxSlidingWindow(nums, k);
//        for (int i : ret) {
//            System.out.println(i);
//        }

        Main m = new Main();
        String s = m.reverseWords("a good   example");
        System.out.println(s);
    }
}
