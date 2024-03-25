READ THIS FIRST BEFORE TRYING THE QUESTION <br>
    
In a grid, if we need to find the path from one source to a destination then we have to options : 
  1. BFS ( **We need an early break condition here** )
  2. A* Algorithm ( extension to djikstra's - used by google maps )

```
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] != 0 || grid[n-1][m-1] != 0) 
            return -1;
        return findPathLength(grid, n, m);
    }
    private int findPathLength(int[][] grid, int n, int m) {
        int[]dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[]dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.offer(new int[]{0, 0});
        visited[0][0] = true; 
        
        int length = 1; // since length of path is number of zero cells visited to reach the end
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                int x = curr[0], y = curr[1];
                // early break
                if(x == n-1 && y == m-1) 
                    return length;
                
                for(int k = 0; k < 8; k++) {
                    int newX = dx[k] + x,
                    newY = dy[k] + y;
                    
                    if(isSafe(newX, newY, n, m) && !visited[newX][newY] && grid[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            length++;
        }
        return -1;
    }
    private boolean isSafe(int x, int y, int n, int m) {
        if(x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }
}
```
