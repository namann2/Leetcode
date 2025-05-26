class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] = min cost to reach ith index
        // dp[i] = jump from i-1 th index or jump from i-2 th index
        // dp[i] = cost[i-1] + cost taken to reach i-1 th index OR cost[i-2] + cost taken to reach to i-2 th index
        // dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        int n = cost.length;
        int[]dp = new int[n+1];
        for(int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }
        return dp[n];
    }
}