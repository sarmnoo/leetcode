import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class MaxAncestorDiff {

    public int maxAncestorDiff(TreeNode root) {
        List<Integer> treeList = new ArrayList<Integer>();
//        levelOrder(treeList, root);
        treeList.add(8);
        treeList.add(3);
        treeList.add(10);
        treeList.add(1);
        treeList.add(6);
        treeList.add(-1);
        treeList.add(14);
        treeList.add(-1);
        treeList.add(-1);
        treeList.add(4);
        treeList.add(7);
        treeList.add(13);

        int maxDiff = 0;
        int tempIndex;
        for (int i = 1; i < treeList.size(); i ++) {
            tempIndex = i;
            while (tempIndex != 0 && treeList.get(i) != -1) {
                if (tempIndex % 2 == 0) {
                    tempIndex = (tempIndex - 2) / 2;
                } else {
                    tempIndex = (tempIndex - 1) / 2;
                }
                maxDiff = Math.max(maxDiff, Math.abs(treeList.get(i) - treeList.get(tempIndex)));
            }
        }
        return maxDiff;
    }

    public void levelOrder(List<Integer> treeList, TreeNode root) {
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while (!nodeList.isEmpty()) {
            TreeNode node = nodeList.poll();
            if (node != null) {
                nodeList.offer(node.left);
                nodeList.offer(node.right);
                treeList.add(node.val);
            } else {
                treeList.add(null);
            }
        }
    }

    public static void main(String[] args) {
        MaxAncestorDiff solution = new MaxAncestorDiff();
        int maxDiff = solution.maxAncestorDiff(null);
        System.out.print(maxDiff);
    }
}
