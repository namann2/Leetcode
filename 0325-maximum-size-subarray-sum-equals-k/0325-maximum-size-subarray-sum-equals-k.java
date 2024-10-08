class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> sumToIndexMap = new HashMap<>();
        sumToIndexMap.put(0, -1);
        int sum = 0, maxLength = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sumToIndexMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - sumToIndexMap.get(sum - k));
            }
            sumToIndexMap.putIfAbsent(sum, i); 
            // this is analogical to x-k, which needs to be minimal since, we need to maximise k
            // if we need to maximise k, we need smallest length where we have seen x-k hence,
            // we update `sum` only once
        }
        return maxLength;
    }
}