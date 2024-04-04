class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) return 0;
        int[][]dp = new int[n][m];
        
        // first row
        for(int j=0;j<m;j++) {
            if(obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        
        // first column
        for(int i=0;i<n;i++) {
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}