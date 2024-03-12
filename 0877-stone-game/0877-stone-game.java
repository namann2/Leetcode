class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][]dp = new int[n][n];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return stoneGame(piles, 0, n-1, dp) > 0;
        
        for(int left = 0; left < n; left++) {
            for(int right = n - 1; right >= 0; right--) {
                if(left == right) dp[left][right] = piles[left];
                else {
                    dp[left][right] = Math.max(piles[left] - (left + 1 < n ? dp[left + 1][right] : 0), 
                                              piles[right] - (right - 1 >= 0 ? dp[left][right - 1] : 0));
                }
            }
        }
        return dp[0][n-1] > 0;
    }
    private int stoneGame(int[] piles, int left, int right, int[][]dp) {
        // base case
        if(left == right) {
            return piles[left];
        }
        if(dp[left][right] != -1) return dp[left][right];
        // main logic
        int option1 = piles[left] - stoneGame(piles, left + 1, right, dp);
        int option2 = piles[right] - stoneGame(piles, left, right - 1, dp);

        return dp[left][right] = Math.max(option1, option2); 
    }
}