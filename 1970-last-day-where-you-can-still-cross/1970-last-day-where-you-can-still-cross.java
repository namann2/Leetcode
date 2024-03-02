class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int start = 0, end = cells.length-1, ans = 0;
        int[][]grid = new int[row][col];
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            boolean reached = false;
            fillGrid(grid, cells, mid);
            for(int j=0;j<col;j++) {
                if(canReach(grid, 0, j, row, col)) {
                    reached = true;
                    break;
                }
            }
            if(reached) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans+1; // 1 based indexing
    }
    
    private void fillGrid(int[][] grid, int[][]cells, int n) {
        // resetting the values
        for(int[] row : grid) 
            Arrays.fill(row, 0);
        
        for(int i = 0;i <= n; i++) {
            grid[cells[i][0]-1][cells[i][1]-1] = 1;
        }
    }
    
    private boolean canReach(int[][]grid, int i, int j, int n, int m) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, n, m);
        
        if(isCurrentCellSafe) {
            
            if(i == n-1) return true;
            
            grid[i][j] = 1; // mark the current cell as visited
            
            return 
                canReach(grid, i-1, j, n, m) ||
                canReach(grid, i+1, j, n, m) ||
                canReach(grid, i, j-1, n, m) ||
                canReach(grid, i, j+1, n, m);
        }
        return false;
    }
    private boolean isSafe(int[][]grid, int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 0)
            return true;
        return false;
    }
}