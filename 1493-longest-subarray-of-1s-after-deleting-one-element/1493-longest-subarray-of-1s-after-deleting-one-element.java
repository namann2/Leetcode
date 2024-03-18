class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int begin = 0, end = 0, maxLength = 0, zeros = 0, k = 1;
        while(end < n) {
            if(nums[end] == 1) {
                // we need to delete one char
                maxLength = Math.max(maxLength, end - begin);
                end++;
            } else {
                zeros++;
                while(zeros > k) {
                    if(nums[begin] == 0) zeros--;
                    begin++;
                }
                maxLength = Math.max(maxLength, end - begin);
                end++;
            }
        }
        return maxLength;
    }
}