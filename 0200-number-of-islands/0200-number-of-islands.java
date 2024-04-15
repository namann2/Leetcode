class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int islands = 0;
        boolean[][]visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, n, m, visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int i, int j, int row, int col, boolean[][]visited) {
        
        boolean isCurrentCellSafe = isSafe(grid, i, j, row, col, visited);
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            dfs(grid, i-1, j, row, col, visited);
            dfs(grid, i+1, j, row, col, visited);
            dfs(grid, i, j-1, row, col, visited);
            dfs(grid, i, j+1, row, col, visited);
        }
    }
    private boolean isSafe(char[][] grid, int i, int j, int row, int col, boolean[][]visited) {
        if(i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == '1' && !visited[i][j]) return true;
        return false;
    }
}