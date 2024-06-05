class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length, begin = -1, end  = -1, culprit = -1;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] < minK || nums[i] > maxK) {
                culprit = i;
                continue;
            }
            
            if(nums[i] == minK) begin = i;
            if(nums[i] == maxK) end = i;
            
            int min = Math.min(begin, end);
            
            if(culprit == -1 || culprit < min) {
                ans += min - culprit;
            }
        }
        return ans;
    }
}