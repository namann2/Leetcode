class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, profit = 0, buyPrice = Integer.MAX_VALUE;
        for(int price : prices) {
            if(price > buyPrice) {
                profit += price - buyPrice;
            }
            buyPrice = price;
        }
        return profit;
    }
}