/**
 * Created by ddning on 08/04/2018.
 */
public class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode() {this.children = new TrieNode[26];}
    TrieNode(char c){
        this.val = c;
        this.children = new TrieNode[26];
//        TrieNode node = new TrieNode();
//        node.val = c;
    }
}
