class Solution {
    public int longestOnes(int[] nums, int k) {
        int end = 0, begin = 0, n = nums.length, cnt = 0, maxLength = 0;
        while(end < n) {
            cnt += 1 - nums[end];
            while(cnt > k && begin < end) {
                cnt -= 1 - nums[begin++];
            }
            if(cnt <= k)
                maxLength = Math.max(maxLength, end - begin + 1);
            end ++;
        }
        return maxLength;
    }
}