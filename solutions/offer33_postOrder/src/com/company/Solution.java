package com.company;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Stack;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> nodeList = new Stack<>();
        int root = Integer.MAX_VALUE;  //root为当前最大值，之后遍历的元素都要比root小
        int temp;
        for (int i = postorder.length-1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while(!nodeList.isEmpty()) {
                if (postorder[i] < nodeList.peek()) {  //说明元素i为某个节点的左节点，并且其父节点在nodelist中，比元素i大的最小值。
                    temp = nodeList.pop();
                    if (temp < root) root = temp;
                } else {
                    break;
                }
            }
            nodeList.push(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] postorders = new int[]{1,3,2,6,5};
        boolean ret = solution.verifyPostorder(postorders);
        System.out.println(ret);
    }
}
