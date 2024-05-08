class Solution {
    public int minimumDeleteSum(String A, String B) {
        int n = A.length(), m = B.length();
        int[][]dp = new int[n+1][m+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        
        // return LCS(A, B, n, m, 0, 0, dp);
//         
        
        for(int j = m-1; j >= 0; j--)
            dp[n][j] = dp[n][j+1] + B.charAt(j);
        
        for(int i = n-1; i >= 0; i--)
            dp[i][m] = dp[i+1][m] + A.charAt(i);
            
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(A.charAt(i) == B.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else dp[i][j] = Math.min(A.charAt(i) + dp[i+1][j], B.charAt(j) + dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
    
    private int LCS(String A, String B, int n, int m, int i, int j, int[][]dp) {
        // base case
        if(i == n && j == m)
            return 0;
        if(i == n) {
            int sum = 0;
            while(j < m)
                sum += B.charAt(j++);
            return sum;
        }
        if(j == m) {
            int sum = 0;
            while(i < n)
                sum += A.charAt(i++);
            return sum;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // main logic
        if(A.charAt(i) == B.charAt(j))
            return dp[i][j] = LCS(A, B, n, m, i+1, j+1, dp);
        
        int x = A.charAt(i) + LCS(A, B, n, m, i+1, j, dp);
        int y = B.charAt(j) + LCS(A, B, n, m, i, j+1, dp);
        return dp[i][j] = Math.min(x, y);
    }
}