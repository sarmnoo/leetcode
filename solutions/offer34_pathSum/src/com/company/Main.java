package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int currentSum = 0;
        List<Integer> onePath = new ArrayList<>();
        calculatePathSum(root, target, currentSum, onePath, ret);
        return ret;
    }

    public void calculatePathSum(TreeNode root, int target, int currentSum,
                                 List<Integer> onePath, List<List<Integer>> ret) {
        if (root == null)
            return;

        currentSum = currentSum + root.val;
        onePath.add(root.val);
        if (target == currentSum && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(onePath));
        }
        calculatePathSum(root.left, target, currentSum, onePath, ret);
        calculatePathSum(root.right, target, currentSum, onePath, ret);

        currentSum -= root.val;
        onePath.remove(onePath.size()-1);



    }

    public static void main(String[] args) {
	// write your code here
    }


}
