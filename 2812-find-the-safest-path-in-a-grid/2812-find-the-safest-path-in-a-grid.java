class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        /*
            1. Find out the distance from each cell to the nearest 1
            2. Binary Search from start = 0, end = n + m
                2.1. Do a DFS from 0,0 and update the range
        */
        
        int n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) 
            return 0;
        
        int[][] distanceOfNearestThief = new int[n][n];
        
        // find distance to nearest thief
        findDistanceOfNearestThief(grid, n, distanceOfNearestThief);
        
        int start = 0, end = n + n, ans = 0; 
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(canReachEndCell(grid, 0, 0, distanceOfNearestThief, mid, n, new boolean[n][n])) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
    
    // helper functions
    
    private void findDistanceOfNearestThief(List<List<Integer>> grid, int n, int[][] distanceOfNearestThief) {
        
        for(int[] row : distanceOfNearestThief) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            List<Integer> cols = grid.get(i);
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j, 0});
                    distanceOfNearestThief[i][j] = 0;
                }
            }
        }
        
        // bfs on the grid
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while(!q.isEmpty()) {
            int[] currCell = q.poll();
            int currX = currCell[0], currY = currCell[1], currDis = currCell[2];
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i],
                newY = currY + dy[i],
                newDis = currDis + 1;
                
                if(newX >= 0 && newX < n && newY >= 0 && newY < n && newDis < distanceOfNearestThief[newX][newY]) {
                    distanceOfNearestThief[newX][newY] = newDis;
                    q.offer(new int[]{newX, newY, newDis});
                }
            }
        }
    }
    
    private boolean canReachEndCell(List<List<Integer>> grid, int i, int j, int[][] distanceOfNearestThief, int threshold, int n, boolean[][] visited) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, distanceOfNearestThief, threshold, n, visited);
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            if(i == n-1 && j == n-1) return true;
            
            boolean left = canReachEndCell(grid, i, j-1, distanceOfNearestThief, threshold, n, visited);
            if(left) return true;
            boolean right = canReachEndCell(grid, i, j+1, distanceOfNearestThief, threshold, n, visited);
            if(right) return true;
            boolean up = canReachEndCell(grid, i-1, j, distanceOfNearestThief, threshold, n, visited);
            if(up) return true;
            boolean down = canReachEndCell(grid, i+1, j, distanceOfNearestThief, threshold, n, visited);
            if(down) return true;
        }
        return false;
    }
    
    private boolean isSafe(List<List<Integer>> grid, int i, int j, int[][] distanceOfNearestThief, int threshold, int n, boolean[][] visited) {
        if(i >= 0 && i < n && j >= 0 && j < n && !visited[i][j] && distanceOfNearestThief[i][j] >= threshold) {
            return true;
        }
        return false;
    }
}