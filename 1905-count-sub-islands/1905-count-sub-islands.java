class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        // remove all the islands from grid2 which does not have corresponding part in grid1
        // grid2 == 1 && grid2 == 0
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j ++) {
                if(grid1[i][j] == 0 && grid2[i][j] == 1 && !visited[i][j]) {
                    dfs(grid2, i, j, n, m, visited);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j ++) {
                if(grid2[i][j] == 1 && !visited[i][j]) {
                    dfs(grid2, i, j, n, m, visited);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] g2, int i, int j, int n, int m, boolean[][] visited) {
        boolean isCurrentCellSafe = isSafe(g2, i, j, n, m, visited);
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            dfs(g2, i-1, j, n, m, visited);
            dfs(g2, i+1, j, n, m, visited);
            dfs(g2, i, j-1, n, m, visited);
            dfs(g2, i, j+1, n, m, visited);
        }
    }
    private boolean isSafe(int[][]g2, int i, int j, int n, int m, boolean[][] visited) {
        if(i >= 0 && i < n && j >= 0 && j < m && g2[i][j] == 1 && !visited[i][j])
            return true;
        return false;
    }
}