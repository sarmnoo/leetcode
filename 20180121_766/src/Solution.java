import java.util.Random;

/**
 * Created by ddning on 2018/1/21.
 */
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;

        int n = matrix[0].length;
        for(int row = m-1; row >= 0; row --){
            int cur = matrix[row][0];
            int tempRow = row;
            int tempCol = 0;
            while(tempRow < m && tempCol < n && matrix[tempRow][tempCol] == cur){
                tempRow ++;
                tempCol ++;
            }
            if(tempRow < m && tempCol < n && matrix[tempRow][tempCol] != cur){
                return false;
            }
        }

        for(int col = 1; col < n; col ++){
            int cur = matrix[0][col];
            int tempRow = 0;
            int tempCol = col;
            while(tempRow < m && tempCol < n && matrix[tempRow][tempCol] == cur){
                tempRow ++;
                tempCol ++;
            }
            if(tempRow < m && tempCol < n && matrix[tempRow][tempCol] != cur){
                return false;
            }
        }


        for (int i = 0; i < 100; i++)
        {
            Random r = new Random();

            System.out.println(r.nextInt());
        }
        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        boolean ret = s.isToeplitzMatrix(new int[][]{{1}});
        System.out.print(ret);
    }
}
