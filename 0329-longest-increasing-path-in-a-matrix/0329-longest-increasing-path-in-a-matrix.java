class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int length = 0;
        int[][] dp = new int[n][m];
        
        for(int[]row : dp)
            Arrays.fill(row, -1);
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int currLength = dfs(matrix, -1, i, j, n, m, dp);
                if(length < currLength)
                    length = currLength;
            }
        }
        return length;
    }
    private int dfs(int[][] grid, int last, int i, int j, int n, int m, int[][]dp) {
        // main logic
        boolean isCurrentCellSafe = isSafe(grid, last, i, j, n, m);
        if(isCurrentCellSafe) {
            if(dp[i][j] != -1) return dp[i][j];
            
            int left = dfs(grid, grid[i][j], i, j-1, n, m, dp);
            int right = dfs(grid, grid[i][j], i, j+1, n, m, dp);
            int top = dfs(grid, grid[i][j], i-1, j, n, m, dp);
            int bottom = dfs(grid, grid[i][j], i+1, j, n, m, dp);
            
            dp[i][j] = 1 + Math.max(dp[i][j], Math.max(Math.max(left, right), Math.max(top, bottom)));
            return dp[i][j];
        }
        return 0;
    }
    
    private boolean isSafe(int[][] grid, int last, int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m && grid[i][j] > last) return true;
        return false;
    }
}