/**
 * Created by ddning on 09/04/2018.
 */
public class TrieNode {
    boolean isword;
    char val;
    TrieNode[] children = new TrieNode[26];

    TrieNode(char c){
        val = c;
        isword = false;
    }
}
