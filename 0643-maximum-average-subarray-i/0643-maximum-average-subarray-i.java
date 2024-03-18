class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = -Double.MAX_VALUE;
        int end = 0, begin = 0, n = nums.length, sum = 0;
        while(end < n) {
            sum += nums[end];
            if(end - begin + 1 == k) {
                ans = Math.max(ans, (1d * sum / k));
                sum -= nums[begin++];
            }
            end++;
        }
        return ans;
    }
}