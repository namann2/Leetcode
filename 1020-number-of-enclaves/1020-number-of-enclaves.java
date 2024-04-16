class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][]visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0 || i == n-1 || j == m-1) 
                    dfs(grid, i, j, n, m, visited);
            }
        }
        
        int land = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j])
                    land++;
                    // no need :: land += dfs(grid, i, j, n, m, visited);
            }
        }
        
        return land;
    }
    private int dfs(int[][]grid, int i, int j, int n, int m, boolean[][]visited) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, n, m, visited);
        int result = 0;
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            result = 1 + dfs(grid, i-1, j, n, m, visited) +
                            dfs(grid, i+1, j, n, m, visited) +
                                dfs(grid, i, j-1, n, m, visited) +
                                    dfs(grid, i, j+1, n, m, visited);
        }
        return result;
    }
    private boolean isSafe(int[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        if(i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1 && !visited[i][j])
            return true;
        return false;
    }
}