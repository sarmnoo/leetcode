package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean verifyPostorder(int[] postorder) {
        boolean ret = true;
        TreeNode root = null;
        for (int i = postorder.length - 1; i >= 0; i --) {
            if (root == null) {
                root = new TreeNode(postorder[i]);
            } else {
                TreeNode cur = root;
                if (insertTreeNode (cur, postorder[i]) == false) {
                    return false;
                }
            }
        }

        return ret;
    }

    public boolean insertTreeNode(TreeNode cur, int val) {
        while(cur != null){   //寻找叶子节点
            if(val < cur.val){
                if(cur.left == null){
                    cur.left = new TreeNode(val);
                    if (cur.right == null) {
                        cur.right = new TreeNode(Integer.MAX_VALUE);
                    }
                    break;
                }
                cur = cur.left;
            }
            else{
                if (cur.right != null && cur.right.val == Integer.MAX_VALUE) {
                    return false;
                }
                if(cur.right == null){
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }
        }
        return true;
    }
}
