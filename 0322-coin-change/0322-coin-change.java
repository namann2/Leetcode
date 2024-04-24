class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][]dp = new int[n + 1][amount + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int ans = coinChange(coins, 0, n, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int coinChange(int[] coins, int index, int n, int target, int[][]dp) {
        // base case
        if(target == 0) {
            // min = Math.min(min, new ArrayList<>(temp).size());
            return 0;
        }
        if(target < 0) return Integer.MAX_VALUE;
        if(index == n) return Integer.MAX_VALUE;
        if(dp[index][target] != -1)
            return dp[index][target];
        // main logic
        int ans = Integer.MAX_VALUE;
        for(int i = index; i < n; i++) {
            int x = coinChange(coins, i, n, target - coins[i], dp);
            if(x != Integer.MAX_VALUE) ans = Math.min(ans, 1 + x);
        }
        return dp[index][target] = ans;
    }
}