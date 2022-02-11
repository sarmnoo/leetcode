package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] coins = new int[]{1};
        int amount = 0;
        int i = main.coinChange(coins, amount);
        System.out.println(i);
    }

    /**
     * 采用动态规划算法
     * f[i] 表示金额为i的可兑换的最少硬币数
     * 例如 硬币为[1,2,5]
     * f[5] = min(f[5-1],f[5-2],f[5-5]) + 1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] ret = new int[amount + 1];
        Arrays.fill(ret, max);
        ret[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    ret[i] = Math.min(ret[i], ret[i - coins[j]] + 1);
                }
            }
        }
        return ret[amount] > amount? -1:ret[amount];
    }
}
