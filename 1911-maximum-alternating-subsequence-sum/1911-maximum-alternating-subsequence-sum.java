class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        // dp state -> max alternating sum of a subsequence ending at ith index
        long[][]dp = new long[n][2]; 
        for(long[] arr : dp)
            Arrays.fill(arr, -1l);
        return helper(nums, 0, 1, n, dp);
    }
    private long helper(int[] A, int index, int sign, int n, long[][]dp) {
        // base case
        if(index >= n) return 0;
        if(dp[index][(sign+1)/2] != -1)
            return dp[index][(sign+1)/2];
        
        // main logic
        long pick = A[index] * sign + helper(A, index+1, -sign, n, dp);
        long dont_pick = helper(A, index+1, sign, n, dp);
        return dp[index][(sign+1)/2] = Math.max(pick, dont_pick);
    }
}