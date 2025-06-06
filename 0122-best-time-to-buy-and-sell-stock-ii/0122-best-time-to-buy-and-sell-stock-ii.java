class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0, buyPrice = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(prices[i] > buyPrice) {
                profit += prices[i] - buyPrice;
            }
            buyPrice = prices[i];
        }
        return profit;
    }
}