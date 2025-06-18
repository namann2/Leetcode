class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int num : nums) max = Math.max(max, num);

        int[] numberCount = new int[max + 1];
        for(int num : nums) numberCount[num]++;

        int[]dp = new int[max + 1];
        for(int index = max; index >= 0; index--) {
            int pick = (numberCount[index] * index) + (index + 2 < max + 1 ? dp[index + 2] : 0);
            int skip = index + 1 < max + 1 ? dp[index + 1] : 0;
            dp[index] = Math.max(pick, skip);
        }
        return dp[0];
    }
}