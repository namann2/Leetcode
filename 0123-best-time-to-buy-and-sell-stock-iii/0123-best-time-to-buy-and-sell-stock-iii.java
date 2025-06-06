class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, k = 2;
        Integer[][][]dp = new Integer[n+1][k+1][2];
        // 0 -> can buy = true
        // 1 -> can buy = false
        return maxProfit(prices, 0, n, k, 0, dp);
    }

    // helper function

    private int maxProfit(int[] prices, int index, int n, int k, int canBuy, Integer[][][]dp) {
        // base case
        if(k == 0) return 0;
        if(index == n) return 0;
        if(dp[index][k][canBuy] != null)
            return dp[index][k][canBuy];
        // main logic
        if(canBuy == 0) {
            int buy = -prices[index] + maxProfit(prices, index + 1, n, k, 1, dp);
            int notBuy = maxProfit(prices, index + 1, n, k, 0, dp);
            return dp[index][k][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + maxProfit(prices, index + 1, n, k-1, 0, dp);
            int notSell = maxProfit(prices, index + 1, n, k, 1, dp);
            return dp[index][k][canBuy] = Math.max(sell, notSell);
        }
    }
}