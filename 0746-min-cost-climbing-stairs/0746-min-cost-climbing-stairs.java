class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 2) return Math.min(cost[0], cost[1]);
        int[]dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<n;i++)
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        return Math.min(dp[n-1], dp[n-2]);
    }
}