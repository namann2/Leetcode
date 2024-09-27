class Solution {
    public int minNumberOperations(int[] target) {
        // dp[i] = min number of operations
        // required to convert target[i]
        
        int n = target.length;
        int[] dp = new int[n];
        dp[0] = target[0];

        for(int i = 1; i < n; i++) {
            if(target[i] > target[i-1])
                dp[i] = dp[i-1] + target[i] - target[i-1];
            else dp[i] = dp[i-1];
        }
        return dp[n-1];
    }
}