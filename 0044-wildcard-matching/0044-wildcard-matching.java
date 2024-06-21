class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][]dp = new Boolean[n+1][m+1];
        return wildCardMatch(s, p, 0, 0, n, m, dp);
    }
    
    private boolean wildCardMatch(String s, String p, int i, int j, int n, int m, Boolean[][] dp) {
        // base case
        if(i == n && j == m) return true;
        if(i == n) { 
            while(j < m && p.charAt(j) == '*') j++;
            return j == m;
        }
        if(dp[i][j] != null)
            return dp[i][j];
        
        // main logic
        if(j < m && p.charAt(j) == '*') {
            // can match any sequence of characters
            // zero
            boolean zeroMatch = wildCardMatch(s, p, i, j+1, n, m, dp);
            if(zeroMatch) return dp[i][j] = true;
            // one
            
            boolean oneMatch = wildCardMatch(s, p, i+1, j+1, n, m, dp);
            if(oneMatch) return dp[i][j] = true;
            // more
            
            boolean moreMatch = wildCardMatch(s, p, i+1, j, n, m, dp);
            if(moreMatch) return dp[i][j] = true;
        } else {
            if(i < n && j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'))
                if(wildCardMatch(s, p, i+1, j+1, n, m, dp))
                    return dp[i][j] = true;
        }
        return dp[i][j] = false;
    }
}