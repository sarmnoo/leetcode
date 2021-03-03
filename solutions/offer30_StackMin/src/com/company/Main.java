package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> min = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (min.size() == 0 || min.peek() > x) {
                min.push(x);
            }
        }

        public void pop() {
            if (stack.size() > 0) {
                int top = stack.pop();
                if (min.size() > 0 && top <= min.peek()) {
                    min.pop();
                }
            }

        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
