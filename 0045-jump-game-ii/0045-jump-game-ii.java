class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        // dp state = min number of steps to reach last index from ith index
        for(int i = n-2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for(int jump = 1; jump <= nums[i]; jump++) {
                if(i + jump < n && dp[i+jump] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i+jump]);
            }
            if(dp[i] != Integer.MAX_VALUE) dp[i] ++;
        }
        return dp[0];
    }
}