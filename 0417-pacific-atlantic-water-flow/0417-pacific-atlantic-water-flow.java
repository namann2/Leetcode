class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = heights.length, m = heights[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0)
                    dfs(heights, i, j, n, m, heights[i][j], pacific);
                if(i == n-1 || j == m-1) 
                    dfs(heights, i, j, n, m, heights[i][j], atlantic);
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pacific[i][j] && atlantic[i][j])
                    answer.add(List.of(i, j));
            }
        }
        return answer;
    }
    private void dfs(int[][] heights, int i, int j, int n, int m, int h, boolean[][] visited) {
        boolean isCurrentCellSafe = isSafe(heights, i, j, n, m, h, visited);
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            dfs(heights, i-1, j, n, m, heights[i][j], visited);
            dfs(heights, i+1, j, n, m, heights[i][j], visited);
            dfs(heights, i, j-1, n, m, heights[i][j], visited);
            dfs(heights, i, j+1, n, m, heights[i][j], visited);
        }
    }
    private boolean isSafe(int[][] heights, int i, int j, int n, int m, int h, boolean[][] visited) {
        if(i >= 0 && i < n && j >= 0 && j < m && heights[i][j] >= h && !visited[i][j])
            return true;
        return false;
    }
}