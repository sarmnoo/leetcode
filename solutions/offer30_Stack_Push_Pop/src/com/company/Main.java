package com.company;

import java.util.Stack;

public class Main {


    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int popIndex = 0;
        int pushIndex = 0;
        Stack<Integer> tempStack = new Stack<>();
        while (popIndex < popped.length) {
            while ((pushIndex < pushed.length && pushed[pushIndex] != popped[popIndex])
                    && (tempStack.size() == 0 || (tempStack.size() != 0  && tempStack.peek() != popped[popIndex]))) {
                tempStack.push(pushed[pushIndex]);
                pushIndex ++;
            }
            if (pushIndex < pushed.length && pushed[pushIndex] == popped[popIndex]) {
                popIndex ++;
                pushIndex ++;
                continue;
            }
            if (tempStack.size() != 0 && tempStack.peek() == popped[popIndex]) {
                tempStack.pop();
                popIndex ++;
                continue;
            }
            break;
        }
        if (popIndex != popped.length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3};
        int[] popped = new int[]{3,2,1};
        Main solution = new Main();
        boolean ret = solution.validateStackSequences(pushed, popped);
        System.out.println(ret);
	// write your code here
    }
}
