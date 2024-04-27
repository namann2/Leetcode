class Solution {

    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        int[][]dp = new int[n+1][m+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return recurse(0, 0, ring, key, n, m, dp);
    }

    private int countSteps(int curr, int next, int n) {
        int stepsBetween = Math.abs(curr - next); // clock-wise
        int stepsAround = n - stepsBetween; // anti-clock-wise
        return Math.min(stepsBetween, stepsAround);
    }

    public int recurse(int r, int k, String ring, String key, int n, int m, int[][]dp) {
        // base case
        if (k == m) 
            return 0;
        
        if(dp[r][k] != -1)
            return dp[r][k];
        
        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (ring.charAt(i) == key.charAt(k)) {
                int totalSteps = 1 + countSteps(r, i, n) + recurse(i, k + 1, ring, key, n, m, dp);
                minSteps = Math.min(minSteps, totalSteps);
            }
        }
        return dp[r][k] = minSteps;
    }
}