class Solution {
    int mod = 1000000007;
    public int countPaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[][]dp = new long[n][m];
        for(long[] row : dp) Arrays.fill(row, -1);
        long cnt = 0;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                cnt += (dfs(grid, i, j, n, m, dp, -1) % mod)%mod;
            }
        }
        return (int)(cnt % mod);
    }
    private long dfs(int[][]grid, int i, int j, int n, int m, long[][]dp, int pV) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, n, m, pV);
        if(isCurrentCellSafe) {
            if(dp[i][j] != -1) return dp[i][j];

            long d = dfs(grid, i+1, j, n, m, dp, grid[i][j]) % mod;
            long u = dfs(grid, i-1, j, n, m, dp, grid[i][j]) % mod;
            long r = dfs(grid, i, j+1, n, m, dp, grid[i][j]) % mod;
            long l = dfs(grid, i, j-1, n, m, dp, grid[i][j]) % mod;
            
            dp[i][j] = (1L+l+r+u+d)%mod;
            return dp[i][j];
        }
        return 0;
    }
    private boolean isSafe(int[][]grid, int i, int j, int n, int m, int pV) {
        if(i>=0 & i<n && j>=0 && j<m && grid[i][j] > pV) return true;
        return false;
    }
}