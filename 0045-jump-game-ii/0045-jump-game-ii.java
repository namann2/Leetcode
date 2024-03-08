class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[]dp = new Integer[n];
        dp[n-1] = 0;
        for(int i=n-2;i>=0;i--) {
            int jump = nums[i];
            if(jump == 0) continue;
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= jump; j++) {
                if(i + j <= n-1 && dp[i+j] != null)
                    dp[i] = Math.min(dp[i], dp[i+j]);
            }
            if(dp[i] != Integer.MAX_VALUE)
                dp[i] += 1;
        }
        return dp[0];
    }
}