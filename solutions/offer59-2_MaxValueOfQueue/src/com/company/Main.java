package com.company;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 双端队列实现
 */
class MaxQueue {
    Queue queue;
    Deque maxQueue;
    public MaxQueue() {
        queue = new LinkedBlockingQueue<Integer>();
        maxQueue = new LinkedBlockingDeque();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        } else {
            return (int)maxQueue.peekFirst();
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && (int)maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        if (maxQueue.isEmpty()) {
            return -1;
        } else {
            int queueTop = (int)queue.peek();
            if (queueTop == (int)maxQueue.peekFirst()) {
                maxQueue.pollFirst();
            }
            return (int)queue.poll();
        }
    }
}
public class Main {

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(15);
        int maxValue = obj.max_value();
        obj.push_back(9);
//        int param_3 = obj.pop_front();
        int maxValue2 = obj.max_value();
        System.out.println(maxValue);
//        System.out.println(param_3);
        System.out.println(maxValue2);
    }
}
