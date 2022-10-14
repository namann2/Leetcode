class Solution {
    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0) 
            return 0;
        
        int rows = grid.length, cols = grid[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(i==0 || i==rows-1 || j==0 || j==cols-1 && grid[i][j] == 0) {
                    dfs(grid, rows, cols, i, j);
                }
            }
        }
        
        
        int numberOfClosedIslands = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 0) {
                    numberOfClosedIslands++;
                    dfs(grid, rows, cols, i, j);
                }
            }
        }
        
        return numberOfClosedIslands;
    }
    private void dfs(int[][] grid, int rows, int cols, int i, int j) {
        
        boolean isCurrentCellSafe = isSafe(grid, rows, cols, i, j);
        if(isCurrentCellSafe) {
            grid[i][j] = 2;
            dfs(grid, rows, cols, i-1, j);
            dfs(grid, rows, cols, i+1, j);
            dfs(grid, rows, cols, i, j-1);
            dfs(grid, rows, cols, i, j+1);
        }
    }
    private boolean isSafe(int[][]grid, int rows, int cols, int i, int j) {
        if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j] == 0)
            return true;
        return false;
    }
}