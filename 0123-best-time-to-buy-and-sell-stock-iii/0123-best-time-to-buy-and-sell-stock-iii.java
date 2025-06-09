class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, k = 2;
        Integer[][][]dp = new Integer[n+1][k+1][2];
        /* 2 options
            1. buy
            2. sell
            each option has two choices : can and can not &
            to begin a transaction - we need to buy
        */
        int option = 1; // true means -> I have the option to buy
        return maxProfit(prices, 0, n, k, 1, dp);
    }

    // helper functions

    private int maxProfit(int[] prices, int index, int n, int k, int canBuy, Integer[][][] dp) {
        // base case
        if(k == 0) return 0;
        if(index == n) return 0;
        if(dp[index][k][canBuy] != null) 
            return dp[index][k][canBuy];
        // main logic
        if(canBuy == 1) {
            int buy = -prices[index] + maxProfit(prices, index + 1, n, k, 0, dp);
            int dontBuy = maxProfit(prices, index + 1, n, k, 1, dp);
            return dp[index][k][canBuy] = Math.max(buy, dontBuy);
        } else {
            int sell = prices[index] + maxProfit(prices, index + 1, n, k-1, 1, dp);
            int dontSell = maxProfit(prices, index + 1, n, k, 0, dp);
            return dp[index][k][canBuy] = Math.max(sell, dontSell);
        }
    }
}