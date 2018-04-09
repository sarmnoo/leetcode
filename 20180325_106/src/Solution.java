import apple.laf.JRSUIUtils;

/**
 * Created by ddning on 25/03/2018.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    public TreeNode createTree(int[] inorder,int[] postorder,int inBegin,int inEnd,int poBegin,int poEnd){
        if(inEnd >= inBegin && poEnd >= poBegin){
            int val = postorder[poEnd];

            TreeNode root = new TreeNode(val);
            root.left = root.right = null;

            int in = findRoot(inorder,val,inBegin,inEnd);
            if(in != -1){
                root.left = createTree(inorder,postorder,inBegin,in-1,poBegin,poBegin+in-inBegin-1);
                root.right = createTree(inorder,postorder,in+1,inEnd,poBegin+in-inBegin,poEnd-1);
            }
                return root;
        }
        else{
            return null;
        }
    }

    public int findRoot(int[] inorder,int val,int inBegin,int inEnd){
        for(int i = inBegin; i <= inEnd; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }

    public void preorder(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = s.buildTree(inorder,postorder);
        s.preorder(root);
    }

}
