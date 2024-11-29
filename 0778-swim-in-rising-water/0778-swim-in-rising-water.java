class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int start = 0, end = Integer.MIN_VALUE;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                end = Math.max(end, grid[i][j]);
            }
        }
        
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(canReach(grid, 0, 0, rows, cols, mid, new boolean[rows][cols])) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        
        return ans;
    }
    
    // helper functions
    
    private boolean canReach(int[][] grid, int i, int j, int rows, int cols, int dis, boolean[][] visited) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, rows, cols, dis, visited);
        
        if(isCurrentCellSafe) {
            
            visited[i][j] = true;
            
            if(i == rows - 1 && j == cols - 1)
                return true;
            
            boolean left = canReach(grid, i, j-1, rows, cols, dis, visited);
            if(left) return true;
            boolean right = canReach(grid, i, j+1, rows, cols, dis, visited);
            if(right) return true;
            boolean up = canReach(grid, i-1, j, rows, cols, dis, visited);
            if(up) return true;
            boolean down = canReach(grid, i+1, j, rows, cols, dis, visited);
            if(down) return true;
        }
        return false;
    }
    
    private boolean isSafe(int[][] grid, int i, int j, int rows, int cols, int dis, boolean[][] visited) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && !visited[i][j] && grid[i][j] <= dis) return true;
        return false;
    }
}