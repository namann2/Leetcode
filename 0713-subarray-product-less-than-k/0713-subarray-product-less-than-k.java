class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int begin = 0, end = 0, cnt = 0, prod = 1;
        while(end < n) {
            prod *= nums[end];
            while(prod >= k && begin < end) {
                prod /= nums[begin++];
            }
            if(prod < k) 
                cnt += end - begin + 1;
            end++;
        }
        return cnt;
    }
}