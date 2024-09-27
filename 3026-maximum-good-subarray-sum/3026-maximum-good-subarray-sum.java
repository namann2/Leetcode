class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long[] prefix = new long[n+1];

        for(int i = 1; i < n+1; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        
        long maxSum = Long.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int A = nums[i] - k;
            int B = nums[i] + k;
            if(map.containsKey(A)) {
                maxSum = Math.max(maxSum, prefix[i+1] - prefix[map.get(A)]);
            }
            if(map.containsKey(B)) {
                maxSum = Math.max(maxSum, prefix[i+1] - prefix[map.get(B)]);
            }
            if(map.containsKey(nums[i])) {
                if(prefix[map.get(nums[i])+1] > prefix[i+1]) {
                    map.put(nums[i], i);
                }
            } else map.put(nums[i], i);
        }
        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}