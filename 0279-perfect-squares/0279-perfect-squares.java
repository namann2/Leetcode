class Solution {
    public int numSquares(int n) {
        // dp state - least number of perfect square numbers that sum to i
        int[]dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<n+1;i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++) {
                /* rem represents the number that is left
                   after we sub a perfect square. Since, we least number of perfect squares
                   to be used thus we want a number whose square is as close to i 
                   as much possible thus, we want to minimise the rem
                */
                int rem = i - (j*j);
                dp[i] = Math.min(dp[i], dp[rem]);
            }
            dp[i] += 1;
        }
        return dp[n];
    }
}