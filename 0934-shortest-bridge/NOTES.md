```
class Solution {
public int shortestBridge(int[][] grid) {
if(grid == null || grid.length == 0) {
return 0;
}
int rows = grid.length, cols = rows;
boolean[][]visited = new boolean[rows][cols];
Queue<int[]> q = new LinkedList<>();
for(int i=0;i<rows;i++) {
for(int j=0;-j<cols;j++) {
if(grid[i][j] == 1) {
dfs(grid, i, j, rows, cols, visited, q);
return bfs(grid, q, rows, cols, visited);
}
}
}
return -1;
}
private void dfs(int[][]grid, int i, int j, int rows, int cols, boolean[][]visited, Queue<int[]> q) {
boolean isCurrentCellSafe = isSafe(i, j, rows, cols);
// boundary checks