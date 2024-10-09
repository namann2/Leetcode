The below approaches are somewhat similar in implementation but Approach 3 is very simplified.

# Approach 1 : 

```
class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int rows = grid.length, cols = grid[0].length;
        HashSet<String> distinctIslands = new HashSet<>();
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 1) {
                    String island = dfs(grid, rows, cols, i, j, 'x'); // x is the start of a dfs path
                    distinctIslands.add(island);
                }
            }
        }
        for(String s : distinctIslands) {
            System.out.println(s);
        }
        return distinctIslands.size();
    }
    private String dfs(int[][] grid, int rows, int cols, int i, int j, char dir) {
        
        boolean isCurrentCellSafe = isSafe(grid, rows, cols, i, j);
        
        StringBuilder path = new StringBuilder("-"); // delmiter is important as it differentiates the direction/path
        
        // [[1,1,0],[0,1,1],[0,0,0],[1,1,1],[0,1,0]]
        if(isCurrentCellSafe) {
            path.append(dir);
            
            grid[i][j] = 0;
            
            path.append(dfs(grid, rows, cols, i-1, j, 'u'));
            path.append(dfs(grid, rows, cols, i+1, j, 'd'));
            path.append(dfs(grid, rows, cols, i, j-1, 'l'));
            path.append(dfs(grid, rows, cols, i, j+1, 'r'));
        }
        // path.append("-"); either the delimiter at start/ end of a dfs path
        return path.toString();
    }
    private boolean isSafe(int[][] grid, int rows, int cols, int i, int j) {
        if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j] == 1) {
            return true;
        }
        return false;
    }
}

```

# Approach 2 : 

```
class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int rows = grid.length, cols = grid[0].length;
        
        HashSet<String> distinctIslands = new HashSet<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 1) 
                {
                    String path = dfs(grid, i, j, rows, cols, 'x');
                    distinctIslands.add(path);
                }
            }
        }
        
        
        for(String s : distinctIslands) {
            System.out.println(s);
        }
        
        return distinctIslands.size();
    }
    private String dfs(int[][] grid, int i, int j, int rows, int cols, char dir) {
        
        boolean isCurrentCellSafe = isSafe(grid, i, j, rows, cols);
        
        StringBuilder path = new StringBuilder("*"); // delimeter
        
        if(isCurrentCellSafe) {
            path.append(dir);
            grid[i][j] = 0;
            path.append(dfs(grid, i-1, j, rows, cols, 'u'));
            path.append(dfs(grid, i+1, j, rows, cols, 'd'));
            path.append(dfs(grid, i, j-1, rows, cols, 'l'));
            path.append(dfs(grid, i, j+1, rows, cols, 'r'));
        }
        return path.toString();
    }
    private boolean isSafe(int[][] grid, int i, int j, int rows, int cols) {
        if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j] == 1)
            return true;
        return false;
    }
}
```

# Approach 3 : 

```
class Solution {
    
    private static final String DEL = "#";
    
    public int numDistinctIslands(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Set<String> islands = new HashSet<>();
        boolean[][]visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder currentIsland = new StringBuilder();
                    dfs(grid, i, j, rows, cols, visited, currentIsland);
                    islands.add(currentIsland.toString());
                }
            }
        }
        return islands.size();
    }
    
    private void dfs(int[][] grid, int i, int j, int rows, int cols, boolean[][]visited, StringBuilder island) {
        boolean isCurrentCellSafe = isSafe(grid, i, j, rows, cols, visited);
        if(isCurrentCellSafe) {
            visited[i][j] = true;
            dfs(grid, i-1, j, rows, cols, visited, island.append("U").append(DEL));
            dfs(grid, i+1, j, rows, cols, visited, island.append("D").append(DEL));
            dfs(grid, i, j-1, rows, cols, visited, island.append("L").append(DEL));
            dfs(grid, i, j+1, rows, cols, visited, island.append("R").append(DEL));
        }
    }
    
    private boolean isSafe(int[][]grid, int i, int j, int rows, int cols, boolean[][] visited) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && grid[i][j] == 1 && !visited[i][j]) {
            return true;
        }
        return false;
    }
}
```
