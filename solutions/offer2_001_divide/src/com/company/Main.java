package com.company;

public class Main {

    /**
     * 整数除法，不能使用乘法、除法
     * @param a
     * @param b
     * @return
     */
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            //溢出
            return Integer.MAX_VALUE;
        }
        //判断结果符号
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        //如果用绝对值进行计算，会溢出，因为integer的最小值的绝对值超出integer最大值，所以用负数来进行计算
        int ret = 0;
        a = a > 0 ? -a:a;
        b = b > 0 ? -b:b;
        while (a <= b) {
            int value = b;
            int k = 1;
            while (value >= Integer.MIN_VALUE && a <= value + value) {
                value += value;
                k += k;
            }
            a -= value;
            ret += k;
        }

        return sign == 1 ? ret : -ret;
    }

    public int divide2(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            //溢出
            return Integer.MAX_VALUE;
        }
        //判断结果符号
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        //如果用绝对值进行计算，会溢出，因为integer的最小值的绝对值超出integer最大值，所以用负数来进行计算
        int ret = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        for (int i = 31; i >= 0; i--) {
            // >>> 无符号右移
            //首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：将 -2147483648 看成 2147483648
            if ((a >>> i) - b >= 0) {
                a -= b << i;
                ret += 1 << i;
            }
        }

        return sign == 1 ? ret : -ret;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.divide2(Integer.MIN_VALUE,-1));

        int a = Integer.MIN_VALUE;
        System.out.println(Math.abs(Math.abs(a)+1));
    }
}
