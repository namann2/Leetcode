class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        for(int i=0;i<n;i++) {
            for(int j=1;j<m;j++) {
                grid[i][j] += grid[i][j-1];
            }
        }
        for(int j=0;j<m;j++) { // col
            for(int i=1;i<n;i++) { // row
                grid[i][j] += grid[i-1][j];
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] <= k) ++ans;
                else break;
            }
        }
        return ans;
    }
}