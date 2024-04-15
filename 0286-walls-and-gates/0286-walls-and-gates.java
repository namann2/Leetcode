class Solution {

    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length, m = rooms[0].length;
        int max = 2147483647;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j, n, m);
                }
            }
        }
    }
    private void bfs(int[][]rooms, int i, int j, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        int[]dx = {-1, 1, 0, 0};
        int[]dy = {0, 0, -1, 1};
        q.offer(new int[]{i, j, 0});
        while(!q.isEmpty()) {
            int size = q.size();
            for(int l = 0; l < size; l++) {
                int[] curr = q.poll();
                for(int k = 0; k < 4; k++) {
                    int newX = curr[0] + dx[k];
                    int newY = curr[1] + dy[k];
                    int newD = curr[2] + 1;
                    boolean isCurrentCellSafe = isSafe(rooms, newX, newY, n, m, newD);
                    if(isCurrentCellSafe) {
                        rooms[newX][newY] = newD;
                        q.add(new int[]{newX, newY, newD});
                    }
                }
            }
        }
    }
    private boolean isSafe(int[][] rooms, int i, int j, int n, int m, int dis) {
        if(i >= 0 && i < n && j >= 0 && j < m && rooms[i][j] != -1 && rooms[i][j] > dis) return true;
        return false;
    }
}