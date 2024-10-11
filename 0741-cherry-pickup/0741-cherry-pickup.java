class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if(grid[0][0] == -1 || grid[rows-1][cols-1] == -1)
            return 0;
        Integer[][][][]dp = new Integer[rows][rows][cols][cols];
        return Math.max(0, cherryPick(grid, 0, 0, 0, 0, rows, cols, dp));
    }
    
    private int cherryPick(int[][] grid, int r1, int c1, int r2, int c2, int rows, int cols, Integer[][][][] dp) {
        // base case
        // if we went out of the grid or hit a thorn, discourage this path by returning Integer.MIN_VALUE
        if(r1 >= rows || r2 >= rows || c1 >= cols || c2 >= cols || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        
        if(dp[r1][r2][c1][c2] != null)
            return dp[r1][r2][c1][c2];
        
        // if person 1 reached the bottom right, return what's in there (could be 1 or 0)
        if(r1 == rows - 1 && c1 == cols - 1) {
            return grid[r1][c1];
        }
        
        // if person 2 reached the bottom right, return what's in there (could be 1 or 0)
        if(r2 == rows - 1 && c2 == cols - 1) {
            return grid[r2][c2];
        }
        
        // main logic
        int cherries = 0;
        // if both person are on same cell, get the value of it once
        if(r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }
        
        int r1r2 = cherryPick(grid, r1 + 1, c1, r2 + 1, c2, rows, cols, dp);
        int c1c2 = cherryPick(grid, r1, c1 + 1, r2, c2 + 1, rows, cols, dp);
        int r1c2 = cherryPick(grid, r1 + 1, c1, r2, c2 + 1, rows, cols, dp);
        int c1r2 = cherryPick(grid, r1, c1 + 1, r2 + 1, c2, rows, cols, dp);
        
        cherries += Math.max(Math.max(r1r2, c1c2), Math.max(r1c2, c1r2));
        return dp[r1][r2][c1][c2] = cherries;
    }
}