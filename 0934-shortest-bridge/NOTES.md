
Examples :

    1 1 0 0 1 
    1 1 0 0 1
    1 1 0 0 0
    
    1 1 1  
    1 0 0  
    0 0 1

```
class Solution {
    public int shortestBridge(int[][] grid) {
        
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, q, i, j, rows, cols, visited);
                    return bfs(grid, q, rows, cols, visited);
                }
            }
        }
        return -1;
    }

    private int bfs(int[][] grid, Queue<int[]> q, int rows, int cols, boolean[][] visited) {

        int[]dx = {-1, 1, 0, 0};
        int[]dy = {0, 0, -1, 1};

        int flips = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                int[] curr = q.poll();
                for(int i = 0; i < 4; i++) {
                    int newX = curr[0] + dx[i];
                    int newY = curr[1] + dy[i];
                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                        if(grid[newX][newY] == 1) 
                            return flips;
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            flips++;
        }
        return flips;
    }

    private void dfs(int[][] grid, Queue<int[]> q, int i, int j, int rows, int cols, boolean[][] visited) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, rows, cols, visited);
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            q.offer(new int[]{i, j});
            dfs(grid, q, i-1, j, rows, cols, visited);
            dfs(grid, q, i+1, j, rows, cols, visited);
            dfs(grid, q, i, j-1, rows, cols, visited);
            dfs(grid, q, i, j+1, rows, cols, visited);
        }
    }

    private boolean isSafe(int[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && grid[i][j] == 1 && !visited[i][j]) {
            return true;
        }
        return false;
    }
}
```
