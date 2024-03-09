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
        if(left > right) return 0;
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