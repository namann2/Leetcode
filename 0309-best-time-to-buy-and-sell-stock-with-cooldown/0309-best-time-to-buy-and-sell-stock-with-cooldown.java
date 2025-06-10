class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // option = 1(buy), 0(sell)
        int[][]dp = new int[n+2][2];
        for(int day = n-1; day >= 0; day--) {
            for(int option = 0; option <= 1; option++) {
                if(option == 1) {
                    int buy = -prices[day] + dp[day+1][0];
                    int dontBuy = dp[day+1][1];
                    dp[day][option] = Math.max(buy, dontBuy);
                } else {
                    int sell = prices[day] + dp[day+2][1];
                    int dontSell = dp[day+1][0];
                    dp[day][option] = Math.max(sell, dontSell);
                }
            }
        }
        return dp[0][1];
    }
}