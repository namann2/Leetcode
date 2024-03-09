## Top-Down Approach

```
class Solution {
    public int stoneGameVII(int[] stones) {
        // TC : O(n^2), SC : O(n^2)
        int n = stones.length;
        int[] ps = new int[n];
        ps[0] = stones[0];
        for(int i = 1; i < n ; i++)
            ps[i] = ps[i-1] + stones[i];
        
        int[][]dp = new int[n+1][n+1];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return stoneGame(stones, 0, n-1, ps, dp);
    }
    private int stoneGame(int[] stones, int left, int right, int[] ps, int[][]dp) {
        // base case
				// single element won't increase the score
        if(left >= right) return 0;
        // // base case when only two elements are there in the input
        if(left + 1 == right)
            return Math.max(stones[left], stones[right]);
        
        if(dp[left][right] != -1)
            return dp[left][right];
        // main logic
        int scorePickLeft = (ps[right] - ps[left]) - stoneGame(stones, left + 1, right, ps, dp);
        int scorePickRight = (ps[right - 1] - (left <= 0 ? 0 : ps[left-1])) - stoneGame(stones, left, right - 1, ps, dp);
        
        return dp[left][right] = Math.max(scorePickLeft, scorePickRight);
    }
}
```

## Bottom up DP

```
class Solution {
    public int stoneGameVII(int[] stones) {
        // TC : O(n^2), SC : O(n^2)
        int n = stones.length;
        int[] ps = new int[n];
        ps[0] = stones[0];
        for(int i = 1; i < n ; i++)
            ps[i] = ps[i-1] + stones[i];
        
        int[][]dp = new int[n+1][n+1];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= n - 1; j++) {
                if(i >= j) continue;
                else if(i + 1 == j) dp[i][j] = Math.max(stones[i], stones[j]);
                else {
                    int left = (ps[j] - ps[i]) - dp[i+1][j];
                    int right = ps[j-1] - (i == 0 ? 0 : ps[i-1]) - dp[i][j-1];
                    dp[i][j] = Math.max(left, right);
                }
            }
        }
        return dp[0][n-1];
    }
}
```
