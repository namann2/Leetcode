class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int K = 2;
        int[][] next = new int[K+1][2];
        // iteration
        for(int index = n-1; index >= 0; index--) {
            int[][] curr = new int[K+1][2];
            for(int k = 2; k > 0; k--) {
                for(int option = 0; option < 2; option++) {
                    if(option == 1) {
                        int buy = -prices[index] + next[k][0];
                        int dontBuy = next[k][1];
                        curr[k][option] = Math.max(buy, dontBuy);
                    } else {
                        int sell = prices[index] + next[k-1][1];
                        int dontSell =next[k][0];
                        curr[k][option] = Math.max(sell, dontSell);
                    }
                }
            }
            next = curr;
        }
        // return
        return next[K][1];
    }
}