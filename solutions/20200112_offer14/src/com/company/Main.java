package com.company;

public class Main {


    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        int p = 1000000007;
        long temp;
        if (b == 0) return (int)modP(a, p);
        if (b == 1) {
            temp = modP(a-1, p) * 4;
            return (int)(temp % p);
        } else{
            temp = modP(a, p) * 2;
            return (int)(temp % p);
        }
    }

    public long modP(int c, int p) {
        long res = 1;
        while(c > 0) {
            res = (res * 3) % p;
            c --;
        }
        return res;
    }


    /*public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }else if(n == 4){
            return n;
        }
        long res = 1;
        while(n > 4){
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res*n%1000000007);
    }*/

    public static void main(String[] args) {
        Main solution = new Main();
        int result = solution.cuttingRope(127);
        System.out.print(result);
    }
}
