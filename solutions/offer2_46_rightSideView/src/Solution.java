import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> treeNodes = new LinkedBlockingQueue<>();
        treeNodes.offer(root);
        while(!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = treeNodes.poll();
                if (i == 0) {
                    ret.add(node.val);
                }
                if (node.right != null) treeNodes.offer(node.right);
                if (node.left != null) treeNodes.offer(node.left);
            }
        }
        return ret;
    }
}
