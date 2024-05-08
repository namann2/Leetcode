class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = (int)(1e9 + 7);
        int[]dp = new int[high+1];
        dp[0] = 1; // number of good strings of length i
        for(int i = 1; i<= high; i++) {
            if(i - zero >= 0) dp[i] = dp[i - zero] % mod;
            if(i - one >= 0) dp[i] += dp[i - one] % mod;
            dp[i] %= mod;
        }
        
        int ans = 0;
        for(int i = low; i <= high; i++)
            ans = (ans % mod + dp[i] % mod) % mod;
        
        return ans;
    }
}