class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, k = 2;
        int[][][]dp = new int[n+1][k+1][2];

        for(int day = n-1; day >= 0; day--) {
            for(int transaction = 1; transaction <= k; transaction++) {
                for(int option = 0; option <= 1; option++) {
                    if(option == 1) {
                        int buy = -prices[day] +  dp[day+1][transaction][0];
                        int dontBuy = dp[day+1][transaction][1];
                        dp[day][transaction][option] = Math.max(buy, dontBuy);
                    } else {
                        int sell = prices[day] + dp[day+1][transaction-1][1];
                        int dontSell = dp[day+1][transaction][0];
                        dp[day][transaction][option] = Math.max(sell, dontSell);
                    }
                }
            }
        }
        return dp[0][k][1];
    }
}