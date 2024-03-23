class Solution {
    public int minDistance(String A, String B) {
        int n = A.length(), m = B.length();
        int[][]dp = new int[n+1][m+1];
        for(int i = n-1; i>= 0; i--) {
            for(int j = m-1; j>=0 ; j--) {
                if(A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return n - dp[0][0] + m - dp[0][0];
    }
}