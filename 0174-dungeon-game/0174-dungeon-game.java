class Solution {
    public int calculateMinimumHP(int[][] D) {
        // check thought process in notes
        int n = D.length, m = D[0].length;
        int[][]dp = new int[n][m];
        
        for(int i=n-1;i>=0;i--) {
            for(int j=m-1;j>=0;j--) {
                if(i == n-1 && j == m-1) { // last cell
                    dp[i][j] = D[i][j] < 0 ? 1 + -D[i][j] : 1;
                } else if(i == n-1) { // last row
                    dp[i][j] = Math.max(1, dp[i][j+1] - D[i][j]);
                } else if(j == m-1) { // last column
                    dp[i][j] = Math.max(1, dp[i+1][j] - D[i][j]);
                } else { // we should go to that path which requires less health
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - D[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
