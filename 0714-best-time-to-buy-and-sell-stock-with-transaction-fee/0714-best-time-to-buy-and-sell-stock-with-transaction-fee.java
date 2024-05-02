class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] next = new int[n + 1];
        for(int index = n-1; index >= 0; index--) {
            int[] curr = new int[n + 1];
            for(int j = 0; j < 2; j++) {
                if(j == 0) {
                    curr[0] = Math.max(-prices[index] + next[1], next[0]);
                } else {
                    curr[1] = Math.max(prices[index] - fee + next[0], next[1]);
                }
            }
            next = curr;
        }
        return next[0];
    }
}