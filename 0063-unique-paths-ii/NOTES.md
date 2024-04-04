```
class Solution {
public int uniquePathsWithObstacles(int[][] grid) {
int rows = grid.length;
int cols = grid[0].length;
if(grid[rows-1][cols-1] == 1 || grid[0][0] == 1) return 0;
if(rows == 1 && cols == 1) {
if(grid[0][0] == 1) return 0;
return 1;
}
int[][]dp = new int[rows][cols];
dp[0][0] = 0;
// first row
for(int j=1;j<cols;j++) {
if(grid[0][j] == 1) {
break;
} else {
dp[0][j] = 1;
}
}
// first col
for(int i=1;i<rows;i++) {
if(grid[i][0] == 1) {