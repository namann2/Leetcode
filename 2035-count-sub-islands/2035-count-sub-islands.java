class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid2.length, cols = grid2[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid2[i][j] == 1 && grid1[i][j] == 0 && !visited[i][j]) {
                    dfs(grid2, i, j, rows, cols, visited); // mark all cells as visited
                }
            }
        }

        int subIslands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid2[i][j] == 1 && !visited[i][j]) {
                    dfs(grid2, i, j, rows, cols, visited);
                    subIslands++;
                }
            }
        }

        return subIslands;
    }

    private void dfs(int[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, rows, cols, visited);
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            dfs(grid, i-1, j, rows, cols, visited);
            dfs(grid, i+1, j, rows, cols, visited);
            dfs(grid, i, j-1, rows, cols, visited);
            dfs(grid, i, j+1, rows, cols, visited);
        }
    }

    private boolean isSafe(int[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && !visited[i][j] && grid[i][j] == 1) 
            return true;
        return false;
    }
}