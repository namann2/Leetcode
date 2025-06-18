class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0, zeros = 0;
        for(int num : nums) {
            sum += num;
            if(num == 0) zeros++;
        }
        // taking negative to prevent integer overflow
        if((sum - target) % 2 != 0 || target > sum) return 0;

        int requiredTarget = (sum - target) >> 1;
        // there are zeros in the input as well
        int nonZeroCount = n - zeros;
        int[] nonZeros = new int[nonZeroCount];
        int k = 0;
        for(int num : nums) {
            if(num != 0) nonZeros[k++] = num;
        }
        Integer[][] dp = new Integer[n][requiredTarget + 1];
        int countOfSubsets = findSumWays(nonZeros, nonZeroCount - 1, requiredTarget, dp);
        return countOfSubsets * (1 << zeros);
    }

    // helper function

    private int findSumWays(int[] nums, int index, int target, Integer[][] dp) {
        // base case
        if(target == 0) return 1;
        if(index == 0) {
            if(nums[index] == target) return 1;
            return 0;
        } 
        if(dp[index][target] != null)
            return dp[index][target];
        // main logic
        int skip = findSumWays(nums, index - 1, target, dp);
        int take = 0;
        if(nums[index] <= target) {
            take = findSumWays(nums, index - 1, target - nums[index], dp);
        }
        return dp[index][target] = skip + take;
    }
}
/**

s1 + s2 = sum
s1 - s2 = target

s2 = sum - target / 2
 */