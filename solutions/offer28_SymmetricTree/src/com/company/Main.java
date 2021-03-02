package com.company;

public class Main {

    public boolean isSymmetric(TreeNode root) {
        boolean isSymmetric = judgeTree(root, root);
        return isSymmetric;
    }

    public boolean judgeTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) {
            return false;
        }
        return judgeTree(left.left, right.right) && judgeTree(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
