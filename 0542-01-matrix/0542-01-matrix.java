class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else mat[i][j] = n*m+1;
            }
        }
        
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                for(int k = 0; k < 4; k++) {
                    int newX = x + dx[k], newY = y + dy[k];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < m && (mat[newX][newY] > mat[x][y] + 1)) {
                        mat[newX][newY] = mat[x][y] + 1;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return mat;
    }
}