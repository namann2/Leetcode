class Solution {
    public int longestCommonSubsequence(String s, String p) {
        int n = s.length(), m = p.length();
        int[][]dp = new int[n+1][m+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        // return LCS(s, p, 0, 0, n, m, dp);
        
        dp[n][m] = 0;
        for(int si = n - 1; si >= 0; si--) {
            for(int pi = m - 1; pi >= 0; pi--) {
                if(s.charAt(si) == p.charAt(pi)) {
                    dp[si][pi] = 1 + dp[si+1][pi+1];
                } else
                    dp[si][pi] = Math.max(dp[si+1][pi], dp[si][pi+1]);
            }
        }
        return dp[0][0];
    }
}