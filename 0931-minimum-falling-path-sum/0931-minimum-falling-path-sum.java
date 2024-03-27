class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[]dp = new int[m];
        for(int j = 0; j < m; j++)
            dp[j] = matrix[0][j];
        
        for(int i = 1; i < n; i++) {
            int[] curr = new int[m];
            for(int j = 0; j < m; j++) {
                int tl = j-1 >= 0 ? dp[j-1] : Integer.MAX_VALUE;
                int ab = dp[j];
                int tr = j+1 < m ? dp[j+1] : Integer.MAX_VALUE;
                curr[j] = matrix[i][j] + Math.min(tl, Math.min(ab, tr));
            }
            dp = curr;
        }
        int min = dp[0];
        for(int j = 0; j < m; j++) {
            min = Math.min(min, dp[j]);
        }
        return min;
    }
}