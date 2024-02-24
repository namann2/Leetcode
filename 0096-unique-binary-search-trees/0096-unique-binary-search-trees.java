class Solution {
    public int numTrees(int n) {
        if(n == 1) return 1;
        int[]dp = new int[n+1];
        // dp state dp[i] -> number of possible unique bst 
        // if total number of nodes are i
        dp[0] = dp[1] = 1;
        for(int nodes = 2; nodes <= n; nodes++) {
            int left = 0, right = nodes-1;
            while(left <= nodes-1 && right >= 0) {
                dp[nodes] += dp[left++] * dp[right--];
            }
        }
        return dp[n];
    }
}