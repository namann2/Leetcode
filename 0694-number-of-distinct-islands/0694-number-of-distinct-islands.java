class Solution {
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int cnt = 0;
        Set<List<Pair<Integer, Integer>>> uniques = new HashSet<>();
        boolean [][]visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    List<Pair<Integer, Integer>> curr = new ArrayList<>();
                    dfs(grid, i, j, i, j, n, m, curr, visited);
                    if(curr.size() > 0)
                        uniques.add(curr);
                }
            }
        }
        return uniques.size();
    }
    private void dfs(int[][] grid, int bi, int bj, int i, int j, int n, int m, List<Pair<Integer, Integer>> island, boolean[][] visited) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, n, m, visited);
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            island.add(new Pair(i-bi, j-bj));
            dfs(grid, bi, bj, i+1, j, n, m, island, visited);
            dfs(grid, bi, bj, i-1, j, n, m, island, visited);
            dfs(grid, bi, bj, i, j-1, n, m, island, visited);
            dfs(grid, bi, bj, i, j+1, n, m, island, visited);
        }
    }
    private boolean isSafe(int[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        if(i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1 && !visited[i][j]) return true;
        return false;
    }
}