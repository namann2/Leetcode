class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] prev = new int[m];
        for(int i=0;i<n;i++) {
            int[] curr = new int[m];
            for(int j=0;j<m;j++) {
                if(i == 0) {
                    curr[j] = j-1 >= 0 ? curr[j-1] + grid[i][j] : grid[i][j];
                } else if(j == 0) {
                    curr[j] = i-1 >= 0 ? prev[j] + grid[i][j] : grid[i][j];
                } else {
                    curr[j] = grid[i][j] + Math.min(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }
}