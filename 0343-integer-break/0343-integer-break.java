class Solution {
    public int integerBreak(int n) {
        // base case
        // if(n < 2) return n;
        // // main logic
        // int max = 0;
        // for(int k=1;k<=n-1;k++) {
        //     max = Math.max(max, k * Math.max(n-k, integerBreak(n-k)));
        // }
        // return max;
        // dp state -> max product of i after breaking it into sum of k positive integers
        // TC : O(n^2), SC : O(n)
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            for(int k=1;k<=i-1;k++) {
                dp[i] = Math.max(dp[i], k * Math.max(i-k, dp[i-k]));
            }
        }
        return dp[n];
    }
}