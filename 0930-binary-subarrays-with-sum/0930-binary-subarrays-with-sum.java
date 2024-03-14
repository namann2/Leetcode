class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // subarray sum equals k -> prefix sum
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, sum = 0, n = nums.length;
        map.put(0, 1);
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(map.containsKey(sum - goal)) 
                cnt += map.get(sum - goal);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}