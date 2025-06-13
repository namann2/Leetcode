class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if((sum & 1) == 1) return false;
        int n = nums.length, T = sum / 2;
        // bottom up
        boolean[][]dp = new boolean[n][T + 1];
        // step1 : base case
        for(int index = 0; index < n; index++) dp[index][0] = true;
        for(int target = 0; target < T + 1; target++) {
            if(nums[0] == target) dp[0][target] = true;
        }

        // step2 : iteration
        for(int index = 1; index < n; index ++) {
            for(int target = 0; target < T + 1; target++) {
                boolean skip = dp[index-1][target];
                boolean take = false;
                if(nums[index] <= target) {
                    take = dp[index-1][target - nums[index]];
                } 
                dp[index][target] = take || skip;
            }
        }
        return dp[n-1][T];
    }
}