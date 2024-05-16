class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int end = 0, begin = 0, product = 1, cnt = 0;
        while(end < n) {
            product *= nums[end];
            while(product >= k && begin < end) {
                product /= nums[begin++];
            }
            if(product < k) 
                cnt += end - begin + 1;
            end++;
        }
        return cnt;
    }
}