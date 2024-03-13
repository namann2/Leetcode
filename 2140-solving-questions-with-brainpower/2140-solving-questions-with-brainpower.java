class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        Long[] dp = new Long[n+1];
        return mostPoints(questions, 0, n, dp);
    }
    private long mostPoints(int[][] questions, int index, int n, Long[] dp) {
        // base case
        if(index >= n)
            return 0;
        if(dp[index] != null)
            return dp[index];
        // main logic
        long solve = questions[index][0] + mostPoints(questions, index + questions[index][1] + 1, n, dp);
        long dontsolve = mostPoints(questions, index + 1, n, dp);
        
        return dp[index] = Math.max(solve, dontsolve);
    }
}