class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][]dp = new int[n+1][2];
        int nextDayBuy = 0, nextDayNotBuy = 0;
        for(int index = n - 1; index >= 0; index --) {
            for(int canBuy = 0; canBuy < 2; canBuy++) {
                if(canBuy == 1) {
                    int buy = -prices[index] + nextDayNotBuy; //dp[index+1][0];
                    int notBuy = nextDayBuy;
                    int currDayBuy = Math.max(buy, notBuy);
                    nextDayBuy = currDayBuy;
                } else {
                    int sell = prices[index] - fee + nextDayBuy;
                    int notSell = nextDayNotBuy;
                    int currDayNotBuy = Math.max(sell, notSell);
                    nextDayNotBuy = currDayNotBuy;
                }
            }
        }
        return nextDayBuy; 
    }
}