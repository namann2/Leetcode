class Solution {
    public int getFood(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        boolean[][]visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '*') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    break;
                }
            }
        }
        
        int length = 0;
        
        int[]dx = {-1, 1, 0, 0};
        int[]dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if(grid[curr[0]][curr[1]] == '#') return length;
                for(int k = 0; k < 4; k++) {
                    int newX = curr[0] + dx[k],
                    newY = curr[1] + dy[k];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && grid[newX][newY] != 'X') {
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            length++;
        }
        return -1;
    }
}