class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int end = 0, begin = 0, product = 1;
        int count = 0;
        while(end < n) {
            product *= nums[end];
            while(begin < end && product >= k) {
                product /= nums[begin++];
            }
            if(product < k) {
                count += end - begin + 1;
            }
            end++;
        }
        return count;
    }
}