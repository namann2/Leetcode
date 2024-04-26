class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length, culprit = -1;
        int begin = -1, end = -1;
        long cnt = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] < minK || nums[i] > maxK) {
                culprit = i;
                continue;
            }
            
            if(nums[i] == minK) begin = i;
            if(nums[i] == maxK) end = i;
            
            int t1 = Math.min(begin, end);
            int number_of_subarrays = t1 - culprit; //ending at current index
            if(number_of_subarrays > 0)
                cnt += number_of_subarrays;
        }
        return cnt;
    }
}