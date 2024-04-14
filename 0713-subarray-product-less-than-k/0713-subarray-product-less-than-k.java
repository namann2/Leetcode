class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, n = nums.length;
        int end = 0, begin = 0, cnt = 0;
        // 0,  1, 2, 3
        // 10, 5, 2, 6
        // p = 60
        // [10], [10, 5], [5], [5,2], [2], [5,2,6], [2,6], [6] 
        while(end < n) {
            product *= nums[end];
            while(product >= k && begin < end) {
                product /= nums[begin++];
            }
            if(product < k) {
                cnt += end - begin + 1;
            }
            end++;
        }
        return cnt;
    }
}