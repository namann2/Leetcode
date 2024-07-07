class Solution {
    public int shortestBridge(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][]visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 1) {
                    // add all vertices of 1 island in queue
                    dfs(grid, i, j, rows, cols, q, visited);
                    return bfs(grid, q, visited, rows, cols);
                }
            }
        }
        return -1;
    }
    
    private void dfs(int[][]grid, int i, int j, int rows, int cols, Queue<int[]> q, boolean[][]visited) {
        boolean isCurrentCellSafe = isSafe(i, j, rows, cols, visited) && grid[i][j] == 1;
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            q.add(new int[]{i, j});
            
            dfs(grid, i-1, j, rows, cols, q, visited);
            dfs(grid, i+1, j, rows, cols, q, visited);
            dfs(grid, i, j-1, rows, cols, q, visited);
            dfs(grid, i, j+1, rows, cols, q, visited);
        }
    }
    
    private boolean isSafe(int i, int j, int rows, int cols, boolean[][]visited) {
        if(i>=0 && i<rows && j>=0 && j<cols && !visited[i][j]) 
            return true;
        return false;
    }
    
    private int bfs(int[][]grid, Queue<int[]> q, boolean[][]visited, int rows, int cols) {
        
        int[]dx = {-1, 1, 0, 0}, 
             dy = {0, 0, -1, 1};
        
        int flips = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int l=0;l<size;l++) {
                int[] curr = q.poll();
                int currX = curr[0], currY = curr[1];
                for(int i=0;i<4;i++) {
                    int newX = currX + dx[i],
                        newY = currY + dy[i];

                    if(!isSafe(newX, newY, rows, cols, visited))
                        continue;
                    // early break
                    if(grid[newX][newY] == 1)
                        return flips;

                    visited[newX][newY] = true;
                    q.add(new int[]{newX, newY});
                }
            }
            flips++;
        }
        
        return flips;
    }
}