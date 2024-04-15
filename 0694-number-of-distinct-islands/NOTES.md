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