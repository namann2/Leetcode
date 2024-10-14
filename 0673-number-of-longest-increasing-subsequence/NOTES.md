```
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        
        // dp[i] -> length of LIS ending at ith index
        // cnt[i] -> count of all the subsequences of length dp[i] ending at ith index
        int LIS = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) { // we can append nums[i] to all the LIS's ending at jth index
                    // case 1 : does appending nums[i] to subsequences of nums[j] increases the LIS ?
                    if(dp[j] + 1 > dp[i]) {
                        cnt[i] = cnt[j]; // append nums[i] to all the subeq of nums[j]
                        dp[i] = dp[j] + 1;
                    } else if(dp[j] + 1 < dp[i]) {
                        // this is never going to be the case, since dp[i] is built on top of dp[j]
                        // take eg : in worst case, inc and dec sequence
                        // nums = 1 7 and
                        // nums = 7 1
                    } else { // dp[j] + 1 == dp[i] -> we are seeing dp[j] + 1 again, so add nums[i] to all the subs of this element as well
                        cnt[i] += cnt[j];
                    }
                }
            }
            LIS = Math.max(LIS, dp[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == LIS) ans += cnt[i];
        }
        return ans;
    }
}
```
