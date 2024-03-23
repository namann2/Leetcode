class Solution {
    Boolean[][][]dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), k = s3.length();
        if(n + m != k)
            return false;
        dp = new Boolean[n+1][m+1][k+1];
        return isInterLeave(s1, s2, s3, 0, 0, 0, n, m, k);
    }
    private boolean isInterLeave(String A, String B, String C, int i, int j, int k, int n, int m, int l) {
        // base case
        if(i == n && j == m && k == l) {
            return true;
        }
        
        if(dp[i][j][k] != null)
            return dp[i][j][k];
        
        // main logic
        // char a = i < n ? A.charAt(i) : 'A', 
        //      b = j < m ? B.charAt(j) : 'B', 
        //      c = k < l ? C.charAt(k) : 'C';
        // if(a == c && b == c) {
        //     boolean ahead = isInterLeave(A, B, C, i+1, j, k+1, n, m, l);
        //     boolean bhead = isInterLeave(A, B, C, i, j+1, k+1, n, m, l);
        //     return dp[i][j][k] = ahead || bhead;
        // } else if(a == c) {
        //     return dp[i][j][k] = isInterLeave(A, B, C, i+1, j, k+1, n, m, l);
        // } else if(b == c) {
        //     return dp[i][j][k] = isInterLeave(A, B, C, i, j+1, k+1, n, m, l);
        // } else return dp[i][j][k] = false;
        
        boolean r1 = false, r2 = false;
        if(i < n && A.charAt(i) == C.charAt(k)) {
            r1 = isInterLeave(A, B, C, i+1, j, k+1, n, m, l);
        }
        
        if(j < m && B.charAt(j) == C.charAt(k)) {
            r2 = isInterLeave(A, B, C, i, j+1, k+1, n, m, l);
        }
        return dp[i][j][k] = r1 || r2;
    }
}