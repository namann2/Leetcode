class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][]dp = new int[k+1][n];
        // O(k*n^2)
        int localMax = 0;
        
        for(int trans=1;trans<k+1;trans++) {
            localMax = dp[trans-1][0] - prices[0];
            for(int day=1;day<n;day++) {
                dp[trans][day] = Math.max(dp[trans][day-1], localMax + prices[day]);
                localMax = Math.max(localMax, dp[trans-1][day] - prices[day]);
            }
        }
        return dp[k][n-1];
    }
}