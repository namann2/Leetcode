class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][]dp = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i == 0) {
                    dp[i][j] = j-1 >= 0 ? dp[i][j-1] + grid[i][j] : grid[i][j];
                } else if(j == 0) {
                    dp[i][j] = i-1 >= 0 ? dp[i-1][j] + grid[i][j] : grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}