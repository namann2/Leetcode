class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // this is an application of LIS
        // subset means the ordering does not matter
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums);
        
        int[] maps = new int[n];
        for(int i = 0; i < n; i++)
            maps[i] = i;
        
        int[]dp = new int[n];
        int maxLength = 0, lastIndex = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                    maps[i] = j;
                }
            }
            if(dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }
        
        answer.add(nums[lastIndex]);
        while(lastIndex != maps[lastIndex]) {
            lastIndex = maps[lastIndex];
            answer.add(nums[lastIndex]);
        }
            
        Collections.reverse(answer);
        return answer;
    }
}