class Solution {
    public int longestArithSeqLength(int[] nums) {
        // min 3 elements
        int n = nums.length, maxLength = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for(int curr = 1; curr < n; curr++) {
            for(int prev = 0; prev < curr; prev++) {
                if(dp[curr] == null) dp[curr] = new HashMap<>();
                int diff = nums[curr] - nums[prev];
                // if there exist some subsequence with this diff on prev number, consider it
                if(dp[prev] != null && dp[prev].containsKey(diff)) dp[curr].put(diff, dp[prev].get(diff) + 1);
                else dp[curr].put(diff, 1);
                maxLength = Math.max(maxLength, dp[curr].get(diff));
            }
        }
        return maxLength + 1;
    }
}