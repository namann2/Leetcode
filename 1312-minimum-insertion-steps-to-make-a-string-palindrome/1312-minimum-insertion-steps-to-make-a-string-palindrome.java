class Solution {
    public int minInsertions(String A) {
        // SIMILAR TO LCS
        int n = A.length();
        String B = new StringBuilder(A).reverse().toString();
        int[][]dp = new int[n+1][n+1];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1]; 
                } else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return n - dp[0][0];
    }
}