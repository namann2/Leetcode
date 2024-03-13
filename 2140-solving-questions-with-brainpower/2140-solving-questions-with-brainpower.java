class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        Long[] dp = new Long[n+1];
        // return mostPoints(questions, 0, n, dp);
        
        dp[n] = 0l;
        for(int index = n - 1; index >= 0; index --) {
            dp[index] = Math.max(questions[index][0] + (index + questions[index][1] + 1 < n ? dp[index + questions[index][1] + 1] : 0),
                                dp[index+1]);
        }
        return dp[0];
    }
}