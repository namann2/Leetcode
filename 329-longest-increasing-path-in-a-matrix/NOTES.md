Similar Problem : https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/

[Template] https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/1375981/Generic-DFS-Template-or-How-to-solve-DFS-based-problems

I think it is worthy to mention that for most of this kind of questions that we could not add memorization upon a DFS. This question is a special case. Normally when you could move to 4 directions, there would be cycle so you could not memorize the result. However since this question is strictly increasing, thus it is a DAG.


```
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLength = 0;
        
        int[][]dp = new int[rows+1][cols+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                maxLength = Math.max(maxLength, dfs(matrix, dp, i, j, rows, cols, Integer.MIN_VALUE));
            }
        }
        
        return maxLength;
    }
    private int dfs(int[][] matrix, int[][]dp, int i, int j, int rows, int cols, int compareWith) {
        
        boolean isCurrentCellSafe = isSafe(matrix, i, j, compareWith);
    
        int result = 0;
        if(isCurrentCellSafe) {
            
            if(dp[i][j] != -1) return dp[i][j];
                       
            // Go in each direction, and check which path yields the maximum length path
            // This is giving TLE, so we will have to memoize the code
            int d = dfs(matrix, dp, i+1, j, rows, cols, ch) ;
            int u = dfs(matrix, dp, i-1, j, rows, cols, ch) ;
            int r = dfs(matrix, dp, i, j+1, rows, cols, ch) ;
            int l = dfs(matrix, dp, i, j-1, rows, cols, ch) ;
            
            // adding 1, to include the current cell in the path
            result = 1 + Math.max(Math.max(d,u), Math.max(l,r));
            
            dp[i][j] = result;
        }
        return result;
    }
    private boolean isSafe(int[][]matrix, int i, int j, int cw) {
        if(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length && matrix[i][j] > cw) {
            return true;
        }
        return false;
    }
}
```
