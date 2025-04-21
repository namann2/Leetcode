```
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length, cols = grid1[0].length;
        boolean[][] visited2 = new boolean[rows][cols];
        int islands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                // remove all invalid islands from the grid2 where there is land in grid2 but no land in grid1
                // essentially speaking, it is fine if there are extra land in grid1 but
                // any extra land in grid2 must be removed.
                if(grid2[i][j] == 1 && grid1[i][j] == 0 && !visited2[i][j]) {
                    dfs(grid2, i, j, rows, cols, visited2);
                }
            }
        }
        // any remaining islands are valid
        // iterate over grid2 and calculate the number of valid islands that would overlap with grid1
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid2[i][j] == 1 && !visited2[i][j]) {
                    dfs(grid2, i, j, rows, cols, visited2);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(int[][] grid2, int i, int j, int rows, int cols, boolean[][] visited2) {
        boolean isCurrentCellSafe = isSafe(grid2, i, j, rows, cols, visited2);
        if(isCurrentCellSafe) {
            visited2[i][j] = true;
            dfs(grid2, i, j - 1, rows, cols, visited2);
            dfs(grid2, i, j + 1, rows, cols, visited2);
            dfs(grid2, i - 1, j, rows, cols, visited2);
            dfs(grid2, i + 1, j, rows, cols, visited2);
        }
    }
    private boolean isSafe(int[][] grid2, int i, int j, int rows, int cols, boolean[][] visited2) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && !visited2[i][j] && grid2[i][j] == 1) {
            return true;
        }
        return false;
    }
}
```
