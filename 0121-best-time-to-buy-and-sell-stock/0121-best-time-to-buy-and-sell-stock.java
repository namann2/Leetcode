class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, buy = prices[0], n = prices.length;
        for(int i=1;i<n;i++) {
            if(prices[i] >= buy)
                profit = Math.max(profit, prices[i] - buy);
            else buy = prices[i];
        }
        return profit;
    }
}