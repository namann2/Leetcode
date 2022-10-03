Similar Problem : https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/
​
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/1375981/Generic-DFS-Template-or-How-to-solve-DFS-based-problems
​
I think it is worthy to mention that for most of this kind of questions that we could not add memorization upon a DFS. This question is a special case. Normally when you could move to 4 directions, there would be cycle so you could not memorize the result. However since this question is strictly increasing, thus it is a DAG.
​
​
```
class Solution {
public int longestIncreasingPath(int[][] matrix) {
if(matrix == null || matrix.length == 0) return 0;
int rows = matrix.length;
int cols = matrix[0].length;
int maxLength = 0;
int[][]dp = new int[rows+1][cols+1];
for(int[] row : dp) {
Arrays.fill(row, -1);
}