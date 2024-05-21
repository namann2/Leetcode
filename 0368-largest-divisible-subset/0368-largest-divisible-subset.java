class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> answer = new ArrayList<>();
        
        int n = nums.length;
        
        int[]dp = new int[n];
        int[]prev = new int[n];
        int max = 0;
        int lastIndex = -1;
        
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = i;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    prev[i] = j;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        
        answer.add(nums[lastIndex]);
        while(lastIndex != prev[lastIndex]) {
            lastIndex = prev[lastIndex];
            answer.add(nums[lastIndex]);
        }
        
        Collections.reverse(answer);
        return answer;
    }
}