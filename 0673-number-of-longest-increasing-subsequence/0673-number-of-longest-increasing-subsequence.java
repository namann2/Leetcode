class Solution {
    public int findNumberOfLIS(int[] nums) {
        /*
            Consider : [1,3,5,4,7]
            So, 7 can be the part of two subsequences. We need to store this information.
            
        */
        int n = nums.length;
        int[]dp = new int[n];
        int[]cnt = new int[n]; // cnt of sequence that ends at i with value as dp[i]
        dp[0] = cnt[0] = 1;
        int maxLength = 1;
        for(int i=1;i<n;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
            
            // update the count
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i] && dp[j] + 1 == dp[i])
                    cnt[i] += cnt[j];
            }
            cnt[i] = Math.max(cnt[i], 1);
        }
        
        int ans = 0;
        for(int i=0;i<n;i++)
            if(dp[i] == maxLength) ans += cnt[i];
        
        return ans;
    }
}