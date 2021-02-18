import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddning on 2017/12/24.
 */
public class Solution {
    class Node{
        int number = 0;
        String prefix;
        Node left;
        Node right;
        boolean flag = false;
        public Node(String pre){
            this.prefix = pre;
        }
    }
    private Node root = new Node("");
    public List<String> ipToCIDR(String ip, int range) {
        String[] strs= ip.split("\\.");
        int[] nums = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        String beginStr = "",endStr = "";
        String zero = "00000000";
        for(int i = 0; i < nums.length; i++){
            String bit = Integer.toBinaryString(nums[i]);
            beginStr = beginStr+zero.substring(bit.length()) + bit;
        }
        int flag = 0;
        for(int j = nums.length-1; j >= 0; j--){
            int temp = nums[j];
            nums[j] = (nums[j] + range + flag) % 256;
            flag = (temp +range + flag) / 256;
            range = 0;
            if(flag == 0){
                break;
            }
        }

        for(int j = 0; j < nums.length; j++){
            String bit = Integer.toBinaryString(nums[j]);
            endStr = endStr + zero.substring(bit.length()) + bit;
        }
        long begin = Long.parseLong(beginStr,2);
        long end = Long.parseLong(endStr,2);
        for(long k = begin; k < end; k++){
            creatTree(root,k);
        }
        judgeTree(root);
        List<String> ret = new ArrayList<>();
        scanTree(root,ret);
        return ret;
    }

    public void creatTree(Node root,long k){
        String nodeStr = Long.toBinaryString(k);
        for(int i = 0; i < nodeStr.length(); i++){
            if(nodeStr.charAt(i) == '0'){
                if(root.left == null){
                    root.left = new Node(nodeStr.substring(0,i+1));
                }
                root.left.number += 1;
                root = root.left;
            }else{
                if(root.right == null){
                    root.right = new Node(nodeStr.substring(0,i+1));
                }
                root.right.number += 1;
                root = root.right;
            }
        }
    }

    public void judgeTree(Node root){
        if(root != null){
            judgeTree(root.left);
            judgeTree(root.right);
            if((root.left == null && root.right == null) || (root.left != null && root.left.flag == true
                    && root.right != null && root.right.flag == true)){
                root.flag = true;
            }
        }
    }
    public void scanTree(Node root,List<String> ret){
        String zero = "00000000000000000000000000000000";
        if(root != null){
            if(root.flag == true){
                String num = Integer.toString(32 - (int)(Math.log(root.number)/Math.log(2)));
                root.prefix = root.prefix + zero.substring(root.prefix.length());
                String ip = Integer.toString(Integer.parseInt(root.prefix.substring(0,8),2));
                ip += "."+Integer.toString(Integer.parseInt(root.prefix.substring(8,16),2));
                ip += "."+Integer.toString(Integer.parseInt(root.prefix.substring(16,24),2));
                ip += "."+Integer.toString(Integer.parseInt(root.prefix.substring(24,32),2));
                String tmp = ip+"/"+num;
                ret.add(tmp);
                return ;
            }
            scanTree(root.left,ret);
            scanTree(root.right,ret);
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<String> ret = s.ipToCIDR("255.0.0.255",1);
        for(String str:ret){
            System.out.println(str);
        }
    }
}
