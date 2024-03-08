class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, k = 2;
        int[][][]dp = new int[n+1][2][k+1];
        for(int[][]mat : dp)
            for(int[] row : mat)
                Arrays.fill(row, -1);
        // 0 = can not Buy
        // 1 = can Buy
        return maxProfit(prices, 0, 1, n, 2, dp);
    }
    private int maxProfit(int[] prices, int index, int canBuy, int n, int k, int[][][]dp) {
        // base case
        if(index == n || k == 0) 
            return 0;
        if(dp[index][canBuy][k] != -1)
            return dp[index][canBuy][k];
        
        // main logic
        if(canBuy == 1) {
            int buy = -prices[index] + maxProfit(prices, index+1, 0, n, k, dp);
            int notBuy = maxProfit(prices, index+1, 1, n, k, dp);
            return dp[index][canBuy][k] = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + maxProfit(prices, index+ 1, 1, n, k-1, dp);
            int notSell = maxProfit(prices, index+1, 0, n, k, dp);
            return dp[index][canBuy][k] = Math.max(sell, notSell);
        }
    }
}