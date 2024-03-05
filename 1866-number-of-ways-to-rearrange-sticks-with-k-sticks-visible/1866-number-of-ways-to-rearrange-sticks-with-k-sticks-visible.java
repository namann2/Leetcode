class Solution {
    public int rearrangeSticks(int n, int k) {
        long mod = (long)1e9+7;
        long[][] dp = new long[n+1][k+1];
        dp[1][1] = 1;
        for(int i=2;i<=n;i++)
            dp[i][1] = i-1;
        
        for(int i=2;i<=n;i++) {
            for(int j=1;j<=Math.min(i, k);j++) {
                dp[i][j] = (dp[i-1][j-1] % mod + (dp[i-1][j] % mod * (i-1) % mod) % mod) % mod;
            }
        }
        return (int)(dp[n][k] % mod);
    }
}