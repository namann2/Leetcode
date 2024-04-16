class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return dfs(grid, visited, n, m, i, j);
                }
            }
        }
        return 0;
    }
    private int dfs(int[][] grid, boolean[][] visited, int rows, int cols, int i, int j) {
        
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j] == 0) {
            return 1;
        }
        boolean isCurrentCellSafe = isSafe(grid, visited, rows, cols, i, j);
        
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            return 
                dfs(grid, visited, rows, cols, i-1, j) + 
                dfs(grid, visited, rows, cols, i+1, j) + 
                dfs(grid, visited, rows, cols, i, j-1) + 
                dfs(grid, visited, rows, cols, i, j+1) ;
        }
        return 0;
    }
    private boolean isSafe(int[][] grid, boolean[][]visited, int rows, int cols, int i, int j) {
        if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j] == 1 && !visited[i][j]) {
            return true;
        }
        return false;
    }
}