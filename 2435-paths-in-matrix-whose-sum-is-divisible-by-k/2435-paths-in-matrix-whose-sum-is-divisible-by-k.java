class Solution {
    int mod = (int)1e9+7;
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][][]dp = new int[n+1][m+1][k+1];
        
        for(int[][]row : dp) for(int[]d : row) Arrays.fill(d, -1);
        
        return dfs(grid, 0, 0, 0, n, m, dp, k);
    }
    private int dfs(int[][]grid, int i, int j, int sum, int rows, int cols, int[][][]dp, int rem) {
        
        if(i == rows-1 && j == cols-1) {
            return (sum + grid[i][j])%rem == 0 ? 1 : 0;
        }
        
        boolean isCurrentCellSafe = isSafe(grid, i, j, rows, cols);
        
        if(isCurrentCellSafe) {
            
            if(dp[i][j][sum%rem] != -1)
                return dp[i][j][sum%rem];
            
            int right = dfs(grid, i, j+1, (sum+grid[i][j])%rem, rows, cols, dp, rem);
            int down = dfs(grid, i+1, j, (sum+grid[i][j])%rem, rows, cols, dp, rem);
            
            return dp[i][j][sum%rem] = (right % mod + down % mod) % mod;
            
        }
        return 0;
    }
    private boolean isSafe(int[][]grid, int i, int j, int rows, int cols) {
        if(i>=0 && i<rows && j>=0 && j<cols)
            return true;
        return false;
    }
}