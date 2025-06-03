class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0, buyingPrice = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(buyingPrice > prices[i]) buyingPrice = prices[i];
            else maxProfit = Math.max(maxProfit, prices[i] - buyingPrice);
        }
        return maxProfit;
    }
}