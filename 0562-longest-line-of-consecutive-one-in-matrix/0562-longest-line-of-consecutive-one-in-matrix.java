class Solution {
    public int longestLine(int[][] g) {
        int n = g.length, m = g[0].length;
        int[][][] dp = new int[n][m][4];
   
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(g[i][j] == 0) continue;
                dp[i][j][0] += 1 + (j-1 >= 0 ? dp[i][j-1][0] : 0);
                dp[i][j][1] += 1 + (i-1 >= 0 ? dp[i-1][j][1] : 0);
                dp[i][j][2] += 1 + (i-1 >= 0 && j-1 >= 0 ? dp[i-1][j-1][2] : 0);
                dp[i][j][3] += 1 + (i-1 >= 0 && j+1 < m ? dp[i-1][j+1][3] : 0);
            }
            for(int j = 0; j < m; j++) 
                for(int k = 0; k < 4; k++)
                    max = Math.max(max, dp[i][j][k]);
        }
        return max;
    }
}