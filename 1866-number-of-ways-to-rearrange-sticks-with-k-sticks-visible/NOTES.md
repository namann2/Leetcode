Helpful Links : 
1. https://stackoverflow.com/questions/7692653/google-interview-arrangement-of-blocks
2. https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/discuss/1211070/C%2B%2B-Detailed-Explanation-with-Thought-Process-or-DP
3. https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/discuss/1211169/JavaC%2B%2BPython-Concise-DP-Solution


```
class Solution {
    public int rearrangeSticks(int n, int k) {
        int mod = 1000_000_007;
        int[][]dp = new int[n+1][k+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return waysToArrange(n, k, dp, mod); // TC = SC = O(n * k)
    }
    private int waysToArrange(int n, int k, int [][]dp, int mod) {
        // base case
        if(n==k) return 1;
        if(n < k) return 0;
        if(k == 0) return 0;
        if(dp[n][k] != -1) return dp[n][k];
        // main logic
        dp[n][k] = (int)(1L * waysToArrange(n-1, k-1, dp, mod) + 
                         1L * waysToArrange(n-1, k, dp, mod) * (n-1) % mod) % mod;
        
        return dp[n][k];
    }
}
```
