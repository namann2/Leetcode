class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++)
            dp[i] = new HashMap<>();
        
        dp[0].put(0, 1);
        int maxLength = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                if(dp[j].containsKey(diff))
                    dp[i].put(diff, dp[j].get(diff) + 1);
                else dp[i].put(diff, 2);
                maxLength = Math.max(maxLength, dp[i].get(diff));
            }
        }
        return maxLength;
    }
}