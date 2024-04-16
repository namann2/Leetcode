class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int fresh = 0;
        Deque<int[]> cells = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                else if(grid[i][j] == 2) {
                    cells.offer(new int[]{i, j});
                }
            }
        }
        return fresh > 0 ? bfs(grid, n, m, fresh, cells) : 0;
    }
    private int bfs(int[][]grid, int n, int m, int fresh, Deque<int[]> cells) {
        int[]dx = {-1, 1, 0, 0};
        int[]dy = {0, 0, -1, 1};
        
        int time = 0;
        while(!cells.isEmpty()) {
            int size = cells.size();
            for(int i = 0; i < size; i++) {
                int[] curr = cells.poll();
                for(int k = 0; k < 4; k++) {
                    int newX = curr[0] + dx[k];
                    int newY = curr[1] + dy[k];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                        fresh--;
                        grid[newX][newY] = 2;
                        cells.offer(new int[]{newX, newY});
                    }
                }
            }
            time++;
        }
        return fresh <= 0 ? time - 1 : -1;
    }
}