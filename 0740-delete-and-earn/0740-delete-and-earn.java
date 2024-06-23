class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums)
            max = Math.max(max, num);
        
        int[] count = new int[max + 1];
        for(int num : nums)
            count[num]++;
        
        // 2 2 3 3 3 4
        // 0 1 2 3 4 - index
        // 0 0 2 3 1 
        int[] dp = new int[max+1];
        // dp state - max uptil this index
        dp[0] = 0;
        dp[1] = Math.max(1 * count[1], count[0]);
        for(int i = 2; i < max + 1; i++) {
            int choose = count[i] * i + dp[i-2];
            int dont = dp[i-1];
            dp[i] = Math.max(choose, dont);
        }
        return dp[max];
    }
}