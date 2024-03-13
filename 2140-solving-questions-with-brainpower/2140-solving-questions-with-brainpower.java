class Solution {
    public long mostPoints(int[][] A) {
        int n = A.length;
        Long[] dp = new Long[n+1];
        // return mostPoints(questions, 0, n, dp);
        
        dp[n] = 0l;
        for(int index = n - 1; index >= 0; index --) {
            dp[index] = Math.max(
                A[index][0] + (index + A[index][1] + 1 < n ? dp[index + A[index][1] + 1] : 0),
                                dp[index+1]);
        }
        return dp[0];
    }
}