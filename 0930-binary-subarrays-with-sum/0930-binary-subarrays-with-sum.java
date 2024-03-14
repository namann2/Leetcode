class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // subarray sum equals k -> prefix sum
        // doubt full in sliding window approach
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, sum = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            // possible that current sum equals goal
            if(sum == goal) cnt++;
            if(map.containsKey(sum - goal)) 
                cnt += map.get(sum - goal);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}