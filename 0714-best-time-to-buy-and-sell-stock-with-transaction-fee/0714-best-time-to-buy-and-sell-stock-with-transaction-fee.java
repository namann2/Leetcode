class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][]dp = new int[n+1][2];
        // return maxProfit(prices, 0, n, fee, 0, dp); // 0 - buy, 1 - sell
        
        for(int index = n-1; index >= 0; index--) {
            for(int j = 0; j < 2; j++) {
                if(j == 0) {
                    dp[index][0] = Math.max(-prices[index] + dp[index + 1][1], dp[index + 1][0]);
                } else {
                    dp[index][1] = Math.max(prices[index] - fee + dp[index + 1][0], dp[index + 1][1]);
                }
            }
        }
        return dp[0][0];
    }
    
    private int maxProfit(int[] prices, int index, int n, int fee, int buy, Integer[][] dp) {
        // base case
        if(index == n)
            return 0;
        
        if(dp[index][buy] != null)
            return dp[index][buy];
        
        // main logic
        if(buy == 0) {
            int x = -prices[index] + maxProfit(prices, index + 1, n, fee, 1, dp);
            int y = maxProfit(prices, index + 1, n, fee, 0, dp);
            return dp[index][buy] = Math.max(x, y);
        } else {
            int x = prices[index] - fee + maxProfit(prices, index + 1, n, fee, 0, dp);
            int y = maxProfit(prices, index + 1, n, fee, 1, dp);
            return dp[index][buy] = Math.max(x, y);
        }
    }
}