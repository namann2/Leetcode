class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        int[]dp = new int[n+1];
        int[] prevIndex = new int[n+1];
        int maxLength = 0, lastIndex = -1;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            prevIndex[i] = i;
            for(int j = 0; j < i; j++) {
                if((nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j;
                }
            }
            if(maxLength < dp[i]) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }
        
        answer.add(nums[lastIndex]);
        while(prevIndex[lastIndex] != lastIndex) {
            lastIndex = prevIndex[lastIndex];
            answer.add(nums[lastIndex]);
        }
        return answer;
    }
}