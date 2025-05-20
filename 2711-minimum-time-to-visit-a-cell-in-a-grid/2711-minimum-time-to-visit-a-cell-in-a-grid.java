class Solution {
    public int minimumTime(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // if we can not move to adjacent cells from the start position, return -1
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        // x, y, time
        PriorityQueue<int[]> q = new PriorityQueue<>((p1, p2) -> {
            return p1[2] - p2[2];
        });

        boolean[][]visited = new boolean[rows][cols];
        q.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0], currY = curr[1], currTime = curr[2];
            // early break
            if(currX == rows - 1 && currY == cols - 1) return currTime;
            // explore 4 options from each cell
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i], 
                newY = currY + dy[i];
                // if it is actually possible to reach newCell
                if(isSafe(grid, newX, newY, rows, cols, visited)) {
                    int minTimeRequiredToReachNewCell = grid[newX][newY];
                    if(minTimeRequiredToReachNewCell <= currTime + 1) q.offer(new int[]{newX, newY, currTime + 1});
                    else {
                        int timeToOscillate = minTimeRequiredToReachNewCell - currTime;
                        if(timeToOscillate % 2 == 1) q.offer(new int[]{newX, newY, currTime + timeToOscillate});
                        else q.offer(new int[]{newX, newY, currTime + 1 + timeToOscillate});
                    }
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }

    private boolean isSafe(int[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && !visited[i][j]) return true;
        return false;
    }
}