class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[]dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        if(n == 2) return dp[1];
        // do not rob last house and check for max
        for(int i=2;i<=n-2;i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        int max1 = dp[n-2];
        
        Arrays.fill(dp, 0);
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-2], dp[n-1]);
        // do not rob first house and check for max
        for(int i=n-3;i>=1;i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        
        return Math.max(max1, dp[1]);
    }
}