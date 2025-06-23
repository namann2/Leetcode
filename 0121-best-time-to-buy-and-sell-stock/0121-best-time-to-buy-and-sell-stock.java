class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE, profit = 0;
        int n = prices.length;
        for(int i = 0; i < n; i++) {
            int price = prices[i];
            if(price <= buyPrice) {
                buyPrice = price;
            } else {
                profit = Math.max(profit, price - buyPrice);
            }
        }
        return profit;
    }
}