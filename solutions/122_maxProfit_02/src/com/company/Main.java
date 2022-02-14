package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] prices = new int[]{1,2,3,4,5};
        int i = main.maxProfit(prices);
        System.out.println(i);
    }

    /**
     * 每天有两种状态,f[i]表示第i天交易后最大收益：
     * 交易完成后没有股票(前一天没有股票，或者前一天有股票，今天卖掉)：f[i][0] = max(f[i-1][0], prices[i] + f[i-1][1])
     * 交易完成后有一只股票(前一天有股票，或者前一天没有股票今天买了股票)：f[i][1] = max(f[i-1][1], f[i-1][0] - prices[i])
     * 最终比较f[i][0] 和 f[i][1]的大小
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] f = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                f[i][0] = 0;
                f[i][1] = -prices[i];
            } else {
                f[i][0] = Math.max(f[i-1][0], prices[i] + f[i-1][1]);
                f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i]);
            }
        }
        return Math.max(f[prices.length - 1][0], f[prices.length - 1][1]);
    }
}
