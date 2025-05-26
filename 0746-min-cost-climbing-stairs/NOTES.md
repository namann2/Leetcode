## Bottom Up​ ( Going from smaller index to larger index )

Note : this is much more intuitive than the top down solution.

```
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] = min cost to reach ith index
        // dp[i] = either jump from i-1 th index OR jump from i-2 th index
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
```

## Top Down ( Going from larger index to smaller index )

```
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        // dp state -> min cost to reach top from ith index
        dp[n-1] = cost[n-1];
        dp[n-2] = cost[n-2];
        for(int i = n - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}
```
