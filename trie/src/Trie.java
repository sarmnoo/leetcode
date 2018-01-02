import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddning on 2017/12/11.
 */
public class Trie {
    private class Node{
        private Node[] child;
        private int count; //以该字串为前缀的字符串数
        private int dupNum; //该字符串出现的次数 叶子节点
        private boolean isLeaf;

        public Node(){
            child = new Node[26];
            count = 0;
            dupNum = 0;
            isLeaf = false;
        }
    }
    private Node root;
    public Trie(){
        root = new Node();
    }

    public void insert(String str){
        insert(root,str);
    }

    public void insert(Node root,String str){
        for(int i = 0; i < str.length(); i++){
            if(root.child[str.charAt(i)-'a'] == null){
                root.child[str.charAt(i)-'a'] = new Node();
            }
            root.child[str.charAt(i)-'a'].count ++;
            if(i == str.length()-1){
                root.child[str.charAt(i)-'a'].dupNum ++;
                root.child[str.charAt(i)-'a'].isLeaf = true;
            }
            root = root.child[str.charAt(i)-'a'];
        }
    }

    public boolean isExit(String str){
        return search(root,str);
    }

    public boolean search(Node root,String str){
        for(int i = 0; i < str.length(); i++){
            if(root.child[str.charAt(i)-'a'] == null)
                return false;
            root = root.child[str.charAt(i)-'a'];
        }
        return true;
    }


}
