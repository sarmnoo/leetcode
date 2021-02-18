/**
 * Created by ddning on 2017/12/11.
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        boolean up,left;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j ++){
                up = false;
                left = false;
                if(i-1 < 0 || board[i-1][j] == '.')
                    up = true;
                if(j-1 < 0 || board[i][j-1] =='.')
                    left = true;
                if(up && left && board[i][j] == 'X')
                    count ++;
            }
        }
        return count;
    }
}
