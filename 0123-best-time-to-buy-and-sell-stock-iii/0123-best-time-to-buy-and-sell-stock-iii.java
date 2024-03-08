class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, k = 2;
        int[][][]dp = new int[n+1][2][k+1];
        // TC : O(n * k)
        // SC : O(nk)
        for(int index = n - 1; index >= 0; index --) {
            for(int canBuy = 0; canBuy < 2; canBuy ++) {
                for(int trans = 1; trans <= k; trans ++) {
                    if(canBuy == 1) {
                        int buy = -prices[index] + dp[index+1][0][trans];
                        int notBuy = dp[index+1][1][trans];
                        dp[index][canBuy][trans] = Math.max(buy, notBuy);
                    } else {
                        int sell = prices[index] + dp[index+1][1][trans-1];
                        int notSell = dp[index+1][0][trans];
                        dp[index][canBuy][trans] = Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}