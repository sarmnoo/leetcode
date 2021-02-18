import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddning on 2018/3/7.
 */
public class Solution {
    public long numSubarrayBoundedMax(int[] A, int L, int R) {
        List<Integer> big = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            if(A[i] > R){
                big.add(i);
            }
        }
        int begin = 0,end = A.length;
        long sum = 0,temp = 0;
        for(int j = 0; j < big.size(); j++){
            end = big.get(j);
            sum += getSubNum(begin,end,A,L);
            begin = end+1;
//            temp = combine(end-begin);
//            int sumSmall = 0;
//            for(int k = begin; k < end;){
//                if(A[k] < L){
//                    int smallBegin = k;
//                    while(A[k] < L){
//                        k++;
//                    }
//                    sumSmall += combine(k - smallBegin);
//                }
//                else{
//                    k++;
//                }
//            }
//            sum =sum + (temp - sumSmall);
        }
        if(big.get(big.size() -1) < A.length){
            begin = big.get(big.size() -1)+1;
            end = A.length;
            sum += getSubNum(begin,end,A,L);

        }
        return sum;
    }

    public long getSubNum(int begin,int end,int[] A,int L){
        long sum = 0;
        long temp = 0;
        temp = combine(end-begin);
        int sumSmall = 0;
        for(int k = begin; k < end;){
            if(A[k] < L){
                int smallBegin = k;
                while(A[k] < L){
                    k++;
                }
                sumSmall += combine(k - smallBegin);
            }
            else{
                k++;
            }
        }
        sum =sum + (temp - sumSmall);
        return sum;
    }

    public long combine(int n) {
        long temp = 0;
        for(int j = 1; j <= n; j++){
            temp += combination(n,j);
        }
        return temp;
    }

    public long combination(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }

    public long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        long sum = s.numSubarrayBoundedMax(new int[]{2,1,4,3,5,6,7,8,3,1,2,9},2,4);
//        long sum = s.combine(5);
        System.out.println(sum);
    }
}
