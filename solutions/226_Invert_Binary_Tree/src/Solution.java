public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode invertRoot = new TreeNode(root.val);
        if (root != null) {
            invertChildNode(root, invertRoot);
        }
        return invertRoot;
    }

    public void invertChildNode (TreeNode root, TreeNode invertRoot) {
        if (root != null) {
            invertRoot.left = root.right != null?new TreeNode(root.right.val):null;
            invertRoot.right = root.left != null?new TreeNode(root.left.val):null;
            invertChildNode(root.left, invertRoot.right);
            invertChildNode(root.right, invertRoot.left);
        }
    }
}
