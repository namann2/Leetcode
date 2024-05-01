class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return -1;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n+1][m+1][k+1];
        
        int[]src = new int[]{0, 0, k};
        q.offer(src);
        visited[0][0][k] = true;
        
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if(curr[0] == n-1 && curr[1] == m-1)
                    return steps;
                for(int j = 0; j < 4; j++) {
                    int newX = curr[0] + dx[j];
                    int newY = curr[1] + dy[j];
                    int newK = curr[2];
                    int[] newCell = {newX, newY, newK};
                    if(isSafe(grid, newX, newY, n, m)) {
                        if(grid[newX][newY] == 1) newCell[2]--;
                        if(!visited[newX][newY][newK] && newCell[2] >= 0) {
                            q.offer(newCell);
                            visited[newX][newY][newK] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private boolean isSafe(int[][]grid, int x, int y, int n, int m) {
        if(x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
}