class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, max = 0;
        for(int num : nums) max = Math.max(max, num);
        
        int end = 0, begin = 0;
        long cnt = 0, freq = 0;
        while(end < n) {
            if(nums[end] == max) {
                freq++;
                if(freq >= k) cnt += 1 + n - end - 1;
            }
            while(begin <= end && freq >= k) {
                if(nums[begin] == max) freq--;
                if(freq >= k) cnt += 1 + n - end - 1;
                begin++;
            }
            end++;
        }
    
        return cnt;
    }
}