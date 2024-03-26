class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0, n = nums.length;
        for(int num : nums)
            max = Math.max(max, num);
        
        int[] values = new int[max+1];
        for(int num : nums) 
            values[num] += num;
        
        
        int[]dp = new int[max+1];
        dp[0] = values[0];
        dp[1] = values[1];
        for(int i = 2; i < max+1; i++) {
            dp[i] = Math.max(values[i] + dp[i-2], dp[i-1]);
        }
        
        return dp[max];
    }
}