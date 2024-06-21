class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int island = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j, n, m);
                    island++;
                }
            }
        }
        return island;
    }
    
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, n, m);
        if(isCurrentCellSafe) {
            grid[i][j] = '0';
            dfs(grid, i-1, j, n, m);
            dfs(grid, i+1, j, n, m);
            dfs(grid, i, j-1, n, m);
            dfs(grid, i, j+1, n, m);
        }
    }
    
    private boolean isSafe(char[][] grid, int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == '1')
            return true;
        return false;
    }
}