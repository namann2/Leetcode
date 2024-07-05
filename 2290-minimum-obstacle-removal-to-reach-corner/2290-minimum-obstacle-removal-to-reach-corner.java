class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[2] - b[2];
        });
        
        pq.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0 , 0};
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            if(curr[0] == n-1 && curr[1] == m-1)
                return curr[2];
            
            for(int i = 0; i < 4; i++) {
                int newX = curr[0] + dx[i];
                int newY = curr[1] + dy[i];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pq.offer(new int[]{newX, newY, grid[newX][newY] + curr[2]});
                    // if(grid[newX][newY] == 1) {
                    //     pq.offer(new int[]{newX, newY, curr[2] + 1});
                    // } else pq.offer(new int[]{newX, newY, curr[2]});
                }
            }    
        }
        return 0;
    }
}