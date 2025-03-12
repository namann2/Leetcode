class Solution {
    public int minimumTime(int[][] grid) {
        // Each move you make takes 1 second, if we're unable to move -> GAME OVER
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        PriorityQueue<int[]> q = new PriorityQueue<>((p1, p2) -> {
            return p1[2] - p2[2];
        });

        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        q.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;


        int[]dx = {-1, 1, 0, 0};
        int[]dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            int[] currCell = q.poll();
            int currX = currCell[0], currY = currCell[1], timeToReachCell = currCell[2];
            if(currX == rows - 1 && currY == cols - 1) return timeToReachCell;
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    // if we can reach the next cell
                    if(grid[newX][newY] <= timeToReachCell + 1) q.offer(new int[]{newX, newY, timeToReachCell + 1});
                    else {
                        // we've got to make a move -> jump b/w previous cell and current cell 
                        int timeForWhichWeNeedToHop = grid[newX][newY] - timeToReachCell;
                        if(timeForWhichWeNeedToHop % 2 == 1) q.offer(new int[]{newX, newY, grid[newX][newY]});
                        else q.offer(new int[]{newX, newY, grid[newX][newY] + 1});
                    }
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }
}