class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int rows = grid.size(), cols = rows;
        
        if(grid.get(0).get(0) == 1 || grid.get(rows-1).get(cols-1) == 1) {
            return 0;
        }
        
        // step1 : calculate the nearest distance from thief for each cell
        int[][] distance = new int[rows][cols];
        for(int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // find the distance of nearest 1 for each cell in the grid
        findNearestThiefForEachCellInGrid(grid, rows, cols, distance);
        
        // find the manhatan distance
        return maximumSafenessFactor(distance, rows, cols);
    }
    
    // helper functions
    private void findNearestThiefForEachCellInGrid(List<List<Integer>> grid, int rows, int cols, int[][] distance) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            List<Integer> currRow = grid.get(i);
            for(int j = 0; j < cols; j++) {
                if(grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j, 0});
                    distance[i][j] = 0;
                }
            }
        }
        
        // do a bfs from the cells in queue
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        while(!q.isEmpty()) {
            int[] currCell = q.poll();
            for(int i = 0; i < 4; i++) {
                int newX = currCell[0] + dx[i];
                int newY = currCell[1] + dy[i];
                int newD = currCell[2] + 1;
                
                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && distance[newX][newY] > newD) {
                    distance[newX][newY] = newD;
                    q.offer(new int[]{newX, newY, newD});
                }
            }
        }
    }
    
    private int maximumSafenessFactor(int[][] distance, int rows, int cols) {
        // the range of manhatan distance in the grid
        // aim : whether we are able to get a path with this manhatan distance in the grid
        int start = 0, end = rows + cols, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(doesPathExistWithGivenDistance(distance, 0, 0, rows, cols, mid, new boolean[rows][cols])) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
    
    private boolean doesPathExistWithGivenDistance(int[][] distance, int i, int j, int rows, int cols, int minDistance, boolean[][] visited) {
        
        boolean isCurrentCellSafe = isSafe(distance, i, j, rows, cols, minDistance, visited);
        
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            
            if(i == rows - 1 && j == cols - 1) return true;
            
            boolean left = doesPathExistWithGivenDistance(distance, i, j-1, rows, cols, minDistance, visited);
            if(left) return true;
            boolean right = doesPathExistWithGivenDistance(distance, i, j+1, rows, cols, minDistance, visited);
            if(right) return true;
            boolean up = doesPathExistWithGivenDistance(distance, i-1, j, rows, cols, minDistance, visited);
            if(up) return true;
            boolean down = doesPathExistWithGivenDistance(distance, i+1, j, rows, cols, minDistance, visited);
            if(down) return true;
        }
        return false;
    }
    
    private boolean isSafe(int[][] distance, int i, int j, int rows, int cols, int minDistance, boolean[][] visited) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && distance[i][j] >= minDistance && !visited[i][j]) return true;
        return false;
    }
}