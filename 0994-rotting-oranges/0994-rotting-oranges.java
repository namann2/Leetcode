class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, n = grid.length, m = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][]visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) {
                    q.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        if(fresh == 0) return 0;
        if(q.size() == 0 && fresh > 0) return -1;
        
        return bfs(q, grid, visited, fresh, n, m);
    }
    private int bfs(Deque<int[]> q, int[][] grid, boolean[][] visited, int fresh, int n, int m) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int time = 0;
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i = 0; i < size;i ++) {
                int[] curr = q.removeFirst();
                for(int k = 0; k < 4; k++) {
                    int newX = curr[0] + dx[k];
                    int newY = curr[1] + dy[k];
                    if(newX >=0 && newX < n && newY >= 0 && newY < m && 
                       !visited[newX][newY] && grid[newX][newY] == 1) {
                        fresh--;
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}