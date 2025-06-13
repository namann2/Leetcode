class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if((sum & 1) == 1) return false;
        int n = nums.length, target = sum / 2;
        Boolean[][]dp = new Boolean[n][target + 1];
        return canPartition(nums, n-1, target, dp);
    }

    // helper function
    private boolean canPartition(int[] nums, int index, int target, Boolean[][] dp) {
        // base case
        if(target == 0) return true;
        if(index == 0) return nums[index] == target ? true : false;
        if(dp[index][target] != null)
            return dp[index][target];
        // main logic
        boolean skip = canPartition(nums, index - 1, target, dp);
        boolean take = false;
        if(nums[index] <= target) {
            take = canPartition(nums, index - 1, target - nums[index], dp);
        } 
        return dp[index][target] = take || skip;
    }
}