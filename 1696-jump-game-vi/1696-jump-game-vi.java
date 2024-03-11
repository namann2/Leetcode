class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxScore = nums[n-1];
        // TC : O(n * klogk)
        // SC : O(n)
        dp[n-1] = nums[n-1];
        // we want k max values from i so, [i+1....i+k]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1]; 
        });
        
        pq.offer(new int[]{n-1, dp[n-1]});
        
        for(int i = n - 2; i >= 0; i--) {
            while(pq.peek()[0] - i > k) pq.poll();
            dp[i] = nums[i] + pq.peek()[1];
            pq.offer(new int[]{i, dp[i]});
        }
        return dp[0];
    }
}