class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == -1 || grid[n-1][n-1] == -1) 
            return 0;
        Integer dp[][][][] = new Integer[n][n][n][n];
        int numberOfCherries = cherryPick(grid, dp, 0, 0, 0, 0, n, n);
        return Math.max(numberOfCherries, 0);
    }
    
    // helper functions
    
    private int cherryPick(int[][] grid, Integer[][][][] dp, int r1, int c1, int r2, int c2, int rows, int cols) {
        // base case
        if(r1 >= rows || r2 >= rows || c1 >= cols || c2 >= cols || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        
        if(dp[r1][c1][r2][c2] != null)
            return dp[r1][c1][r2][c2];
            
        if(r1 == rows - 1 && c1 == cols - 1) {
            return grid[r1][c1];
        }
        
        if(r2 == rows - 1 && c2 == cols - 1) {
            return grid[r2][c2];
        }
        
        // main logic
        int cherries = 0;
        if(r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } 
        else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }
        
        int r1c2 = cherryPick(grid, dp, r1 + 1, c1, r2, c2 + 1, rows, cols);
        int r1r2 = cherryPick(grid, dp, r1 + 1, c1, r2 + 1, c2, rows, cols);
        int c1c2 = cherryPick(grid, dp, r1, c1 + 1, r2, c2 + 1, rows, cols);
        int c1r2 = cherryPick(grid, dp, r1, c1 + 1, r2 + 1, c2, rows, cols);
        
        int curr = Math.max(Math.max(r1c2, r1r2), Math.max(c1c2, c1r2));
        return dp[r1][c1][r2][c2] = cherries + curr;
    }
}