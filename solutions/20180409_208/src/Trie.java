/**
 * Created by ddning on 09/04/2018.
 */
public class Trie {
    private TrieNode root;
    Trie(){
        root = new TrieNode(' ');
    }

    public void insert(String word){
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(temp.children[c-'a'] == null){
                temp.children[c-'a'] = new TrieNode(c);
            }
            temp = temp.children[c-'a'];
        }
        temp.isword = true;
    }

    public boolean search(String word){
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(temp.children[c-'a'] == null)
                return false;
            temp = temp.children[c-'a'];
        }
        return temp.isword;
    }

    public boolean startsWith(String prefix){
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(temp.children[c-'a'] == null){
                return false;
            }
            temp = temp.children[c-'a'];
        }
        return true;
    }

    public static void main(String[] args){
        Trie t = new Trie();
        t.insert("abcd");
        t.insert("aaa");
        t.insert("dddyyujelk");
        System.out.println(t.search("aae"));
        System.out.println(t.startsWith("ddd"));
    }
}

