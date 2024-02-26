class Solution {
    public int calculateMinimumHP(int[][] D) {
        /*
            Thought Process : 
            If we need to find the minimum health the knight needs to have, then
            it should be equal to the path which will cost him min loss in health.
            Or in other words, summation of negative values along the path is as min as possible.
            Also, to find min health the positive values won't be taken in consideration.
            
            Since we asked the minimum health, we should be thinking in two terms : 
            1. DFS/BFS
            2. DP
            
            Since we are restricted with two directions, we can optimally use DP to calculate the result.
            If we would have been asked that the knight can go in 4 directions, dp would have been 
            tough (probably questionable) and we would have to use BFS/DFS
            
            Now that we know that DP is the optimal solution, We will try to find/define the dp state.
            If we are not able to define dp state directly, we will think in terms of recursion and then 
            find/define the same.
            
            There are 2 changing variables row and col.
            dp[i][j] = min health required to reach the final cell n-1, m-1 from a cell i,j
        */
        
        int n = D.length, m = D[0].length;
        int[][]dp = new int[n][m];
        
        for(int i=n-1;i>=0;i--) {
            for(int j=m-1;j>=0;j--) {
                if(i == n-1 && j == m-1) { // last cell
                    dp[i][j] = D[i][j] < 0 ? 1 + -D[i][j] : 1;
                } else if(i == n-1) { // last row
                    dp[i][j] = Math.max(1, dp[i][j+1] - D[i][j]);
                } else if(j == m-1) { // last column
                    dp[i][j] = Math.max(1, dp[i+1][j] - D[i][j]);
                } else { // we should go to that path which requires less health
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - D[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}