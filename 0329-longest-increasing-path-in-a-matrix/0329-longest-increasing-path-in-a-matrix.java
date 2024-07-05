class Solution {
    int[][]dp ;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n][m];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        int ans = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, n, m, -1));
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int i, int j, int n, int m, int lastCellValue) {
        boolean isCurrentCellSafe = isSafe(matrix, i, j, n, m, lastCellValue);
        if(isCurrentCellSafe) {
            if(dp[i][j] != -1)
                return dp[i][j];
            
            int l = dfs(matrix, i, j-1, n, m, matrix[i][j]);
            int r = dfs(matrix, i, j+1, n, m, matrix[i][j]);
            int u = dfs(matrix, i-1, j, n, m, matrix[i][j]);
            int d = dfs(matrix, i+1, j, n, m, matrix[i][j]);
            
            return dp[i][j] = 1 + Math.max(Math.max(l, r), Math.max(u, d));
        }
        return 0;
    }
    
    private boolean isSafe(int[][] matrix, int i, int j, int n, int m, int lastCellValue) {
        if(i >= 0 && i < n && j >= 0 && j < m && matrix[i][j] > lastCellValue) {
            return true;
        }
        return false;
    }
}