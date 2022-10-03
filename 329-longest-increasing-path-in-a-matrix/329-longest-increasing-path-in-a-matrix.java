class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int rows = matrix.length, cols = matrix[0].length;
        int[][]dp = new int[rows][cols];
        
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        int longestIncreasingPath = 0;
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(dp[i][j] == -1) 
                    dfs(matrix, i, j, rows, cols, dp, -1);
                longestIncreasingPath = Math.max(longestIncreasingPath, dp[i][j]);
            }
        }
        return longestIncreasingPath;
    }
    
    private int dfs(int[][]matrix, int i, int j, int rows, int cols, int[][]dp, int prevValue) {
        
        boolean isCurrentCellSafe = isSafe(matrix, i, j, rows, cols, prevValue);
        int result = 0;
        if(isCurrentCellSafe) {
            if(dp[i][j] != -1)
                return dp[i][j];
            
            int left = dfs(matrix, i, j-1, rows, cols, dp, matrix[i][j]);
            int right = dfs(matrix, i, j+1, rows, cols, dp, matrix[i][j]);
            int up = dfs(matrix, i-1, j, rows, cols, dp, matrix[i][j]);
            int down = dfs(matrix, i+1, j, rows, cols, dp, matrix[i][j]);
            
            result = 1 + Math.max(Math.max(left, right), Math.max(up, down));
            dp[i][j] = result;
        }
        return result;
    }
    
    private boolean isSafe(int[][]matrix, int i, int j, int rows, int cols, int cm) {
        if(i>=0 && i<rows && j>=0 && j<cols && matrix[i][j] > cm)
            return true;
        return false;
    }
}