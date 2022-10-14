class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int rows = grid.length, cols = grid[0].length, maxArea = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                int tempArea = dfs(grid, rows, cols, i, j);
                maxArea = Math.max(maxArea, tempArea);
            }
        }
        
        return maxArea;
    }
    private int dfs(int[][] grid, int rows, int cols, int i, int j) {
        
        boolean isCurrentCellSafe = isSafe(grid, rows, cols, i, j);
        
        if(isCurrentCellSafe) {
            grid[i][j] = 0;
            
            return 1 + 
                    dfs(grid, rows, cols, i-1, j) + 
                        dfs(grid, rows, cols, i+1, j) +
                            dfs(grid, rows, cols, i, j-1) +
                                dfs(grid, rows, cols, i, j+1);
        }
        return 0;
    }
    private boolean isSafe(int[][] grid, int rows, int cols, int i, int j) {
        if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j] == 1) {
            return true;
        }
        return false;
    }
}