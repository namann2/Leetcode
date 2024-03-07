class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], maxProfit = 0, n = prices.length;
        for(int i = 1; i < n; i++) {
            if(prices[i] > buy) {
                maxProfit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return maxProfit;
    }
}