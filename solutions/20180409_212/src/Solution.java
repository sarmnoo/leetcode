import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ddning on 09/04/2018.
 */

class Pair{
    private int first;
    private int second;
    Pair(int x,int y){
        first = x;
        second = y;
    }
}
public class Solution {
    public List<String> findWords(char[][] board, String[] words){
        List<String> ret = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
            find(board,words[i],ret);
        }
        Set temp = new HashSet(ret);
        List<String> ret1 = new ArrayList<>(temp);
        return ret1;
    }

    public void find(char[][] board,String word,List<String> ret){
        int[][] flagBoard = new int[board.length][board[0].length];
        List<String> find = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && find.size() == 0){
                    isValid(board,flagBoard,i,j,word,0,ret,find);

                }
            }
        }
    }

    public void isValid(char[][] board,int[][] flagBoard,int first,int second,String word,int index,List<String> ret,List<String> find){
        if(index < word.length()){
            if(first >= 0 && first < board.length && second >= 0 && second < board[0].length && flagBoard[first][second] == 0 && board[first][second] == word.charAt(index)){
                flagBoard[first][second] = 1;

                isValid(board,flagBoard,first-1,second,word,index+1,ret,find);
                isValid(board,flagBoard,first,second-1,word,index+1,ret,find);
                isValid(board,flagBoard,first+1,second,word,index+1,ret,find);
                isValid(board,flagBoard,first,second+1,word,index+1,ret,find);

                flagBoard[first][second] = 0;

            }
            return;
        }
        if(find.size() == 0){
            ret.add(word);
            find.add(word);
        }
        return ;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        char[][] board = new char[][]{{'a'}};
        String[] words = new String[]{"a","a"};
        List<String> ret = s.findWords(board,words);
        for(String str:ret){
            System.out.println(str);
        }
    }
}
