class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int n = nums.length;
        
        int minIndex = -1, maxIndex = -1, culprit = -1;
        for(int i = 0; i < n; i ++) {
            if(nums[i] < minK || nums[i] > maxK) {
                culprit = i;
                continue;
            }
            
            if(nums[i] == minK) minIndex = i;
            if(nums[i] == maxK) maxIndex = i;
            
            // 3 4 5 1 5 6 7 8, min = 4, max = 7
            // 3 4 5 6 7 8, min = 4, max = 7
            // 3 [] 8
            // 3 [..] 1 [...] 8
            // therefore, it only makes sense to consider all subarrays ending
            // at current (min) index, because we can not be sure of a culprit 
            // element ahead of current element. Consider : 
            // [3,4,5,6,6,7,8,1], min = 4, max = 7, here the culprit will be the 1
            // thus, contribution of elements till current index is taken.
            int startIndex = Math.min(minIndex, maxIndex);
            // int endIndex = Math.max(minIndex, maxIndex); not required
            
            if(culprit == -1 || culprit < startIndex) 
                ans += (startIndex + 1) - (culprit == -1 ? 0 : culprit + 1);
        }
        
        return ans;
    }
}