class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        return bfs(grid, rows, cols);
    }

    private int bfs(int[][] grid, int rows, int cols) {
        PriorityQueue<int[]> q = new PriorityQueue<>((p1, p2)->{
            return p1[2] - p2[2];
        });
        boolean[][] visited = new boolean[rows][cols];
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        int[]dx = {-1, 1, 0, 0};
        int[]dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0], currY = curr[1], currRemovedObs = curr[2];
            if(currX == rows - 1 && currY == cols - 1) return currRemovedObs;
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i], 
                newY = currY + dy[i];

                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    q.offer(new int[]{newX, newY, currRemovedObs + grid[newX][newY]});
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }
}