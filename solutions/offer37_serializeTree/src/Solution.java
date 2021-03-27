import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> nodeStr = new ArrayList<>();
        Queue nodeList = new LinkedList<TreeNode>();
        nodeList.offer(root);
        nodeStr.add(Integer.toString(root.val));
        while (!nodeList.isEmpty()) {
            TreeNode temp = (TreeNode) nodeList.poll();
            if (temp.left != null) {
                nodeList.offer(temp.left);
                nodeStr.add(Integer.toString(temp.left.val));
            } else {
                nodeStr.add("null");
            }
            if (temp.right != null) {
                nodeList.offer(temp.right);
                nodeStr.add(Integer.toString(temp.right.val));
            } else {
                nodeStr.add("null");
            }
        }

        int index = 0;
        for (int i = nodeStr.size() - 1; i >= 0; i--) {
            if (!nodeStr.get(i).equals("null")) {
                index = i;
                break;
            }
        }
        nodeStr = nodeStr.subList(0,index + 1);
        return nodeStr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        Queue<TreeNode> nodeList = new LinkedList<>();
        data = data.replace("[","");
        data = data.replace("]","");
        String[] nodeStrs = data.split(",");
        TreeNode root = null;
        if (nodeStrs.length != 0) {
            if (!nodeStrs[0].equals("null")) {
                TreeNode temp = new TreeNode(Integer.parseInt(nodeStrs[0]));
                root = temp;
                nodeList.offer(temp);
            }
            int index = 1;
            while (!nodeList.isEmpty()) {
                TreeNode cur = nodeList.poll();

                if (index < nodeStrs.length && !nodeStrs[index].trim().equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(nodeStrs[index].trim()));
                    nodeList.offer(cur.left);
                }
                index ++;
                if (index < nodeStrs.length && !nodeStrs[index].trim().equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(nodeStrs[index].trim()));
                    nodeList.offer(cur.right);
                }
                index ++;

            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ret = solution.serialize(solution.deserialize("[null]"));
        System.out.println(ret);
    }
}
