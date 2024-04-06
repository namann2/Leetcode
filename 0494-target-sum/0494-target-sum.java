class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Integer[][]dp = new Integer[n+1][5001];
        return findWays(nums, 0, n, target, dp);
    }
    private int findWays(int[] nums, int index, int n, int target, Integer[][] dp) {
        if(target == 0 && index == n) return 1;
        if(index == n) return 0;
        if(dp[index][target+1000] != null)
            return dp[index][target+1000];
        int x = 0;
        x += findWays(nums, index + 1, n, target - nums[index], dp);
        x += findWays(nums, index + 1, n, target + nums[index], dp);
        return dp[index][target+1000] = x;
    }
}