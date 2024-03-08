class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][]dp = new int[n+1][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return maxProfit(prices, 0, n, 1, 1, dp);
    }
    private int maxProfit(int[] prices, int index, int n, int canBuy, int coolDown, int[][]dp) {
        // base case
        if(index >= n) return 0;
        if(dp[index][canBuy] != -1)
            return dp[index][canBuy];
        
        // main logic
        if(canBuy == 1) {
            int buy = -prices[index] + maxProfit(prices, index + 1, n, 0, coolDown, dp);
            int notBuy = maxProfit(prices, index + 1, n, 1, coolDown, dp);
            return dp[index][canBuy] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + maxProfit(prices, index + 1 + coolDown, n, 1, coolDown, dp);
            int notSell = maxProfit(prices, index + 1, n, 0, coolDown, dp);
            return dp[index][canBuy] = Math.max(sell, notSell);
        }
    }
}