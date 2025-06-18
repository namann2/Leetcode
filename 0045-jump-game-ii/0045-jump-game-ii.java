class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = n-2; i >= 0; i--) {
            int jumps = nums[i];
            dp[i] = Integer.MAX_VALUE;
            for(int jump = 1; jump <= jumps; jump++) {
                if(i + jump < n && dp[i+jump] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i+jump]);
            }
            if(dp[i] != Integer.MAX_VALUE) dp[i]++;
        }
        return dp[0];
    }
}