package com.company;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Main {


    public int nthUglyNumber(int n) {
        long[] factors = {2,3,5};
        PriorityQueue<Long> integers = new PriorityQueue<>();
        HashSet<Long> longs = new HashSet<>();
        integers.add(1L);
        int nth = 1;
        while (n > 0) {
            long cur = integers.poll();
            nth = (int)cur;
            for (int i = 0; i < factors.length; i++) {
                if (longs.add(nth * factors[i])) {
                    integers.add(nth * factors[i]);
                }
            }
            n --;
        }
        return nth;
    }

    public int nthUglyNumber2(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2,n3), n5);
            if (dp[i] == n2) a ++;
            if (dp[i] == n3) b ++;
            if (dp[i] == n5) c ++;
        }
        return dp[n-1];
    }

    public <T> void out(List<T> array) {
        for (T t : array) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        long i = main.nthUglyNumber(14);
        System.out.println(i);

        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        main.out(arrayList);
    }
}
