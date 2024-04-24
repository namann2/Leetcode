class Solution {
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        int[][]dp = new int[n+1][target+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int min_coins = coinChange(coins, 0, n, target, dp);
        return min_coins == Integer.MAX_VALUE ? -1 : min_coins;
        
        // bottom up
//         for(int i = 0; i < n; i++) {
//             if(target % coins[i] == 0) dp[i][target] = target / coins[i];
//             else dp[i][target] = Integer.MAX_VALUE;
//         }
        
//         for(int i = n - 1; i >= 0; i--) {
//             for(int j = target; j >= 0; j--) {
//                 int skip = dp[i+1][j]; // coinChange(coins, index+1, n, target, dp);
//                 int take = dp[i][j - coins[i]]; // coinChange(coins, index, n, target - coins[index], dp);
//                 if(take != Integer.MAX_VALUE)
//                     take++;
//                 dp[i][j] = Math.min(skip, take);
//             }
//         }
        
//         return dp[0][target] == Integer.MAX_VALUE ? -1 : dp[0][target];
    }
    private int coinChange(int[] coins, int index, int n, int target, int[][]dp) {
        // base case
        if(target == 0) return 0;
        if(index == n) 
            return Integer.MAX_VALUE;
        if(target < 0)
            return Integer.MAX_VALUE;
        
        if(dp[index][target] != -1)
            return dp[index][target];
        
        // main logic
        int skip = coinChange(coins, index+1, n, target, dp);
        int take = coinChange(coins, index, n, target - coins[index], dp);
        if(take != Integer.MAX_VALUE)
            take++;
        
        return dp[index][target] = Math.min(skip, take);
    }
}