import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main (String[] args) {
        Solution pro = new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = pro.reconstructQueue(people);

    }
    public int[][] reconstructQueue(int[][] people){
        int[][] result = new int[0][];
        sort(people);
        for(int i = 0; i < people.length; i++){
            result = insert(people[i],result,people[i][1]);
        }

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        return result;
    }



    public void sort(int[][] people){
        Arrays.sort(people,new Comparator<Object>(){

            @Override
            public int compare(Object o1, Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                if(one[0] > two[0]){
                    return -1;
                }
                else if(one[0] < two[0]){
                    return 1;
                }
                else{
                    if(one[1] > two[1]){
                        return 1;
                    }
                    else if(one[1] < two[1]){
                        return -1;
                    }
                    else
                        return 0;
                }
            }
        });
    }

    public int[][] insert(int[] array,int[][] result,int k){
        int[][] newResult = new int[result.length + 1][];
        for(int i = 0; i < k; i++){
            newResult[i] = result[i];
        }
        newResult[k] = array;
        for(int i = k; i < result.length; i++){
            newResult[i+1] = result[i];
        }
        return newResult;
    }


}
