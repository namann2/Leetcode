class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int end = 0, begin = 0, freq = 0, sum = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);
        while(end < n) {
            sum += nums[end];
            // if sum - k is already seen
            freq += sumCountMap.getOrDefault(sum - k, 0);
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
            end++;
        }
        return freq;
    }
}