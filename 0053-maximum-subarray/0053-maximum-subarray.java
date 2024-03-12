class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], sumEndingAtCurrentIndex = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            // option 1 : ending at nums[i]
            sumEndingAtCurrentIndex += nums[i];
            // option 2 : starting from nums[i]
            maxSum = Math.max(maxSum, nums[i]);
            maxSum = Math.max(maxSum, sumEndingAtCurrentIndex);
            sumEndingAtCurrentIndex = Math.max(sumEndingAtCurrentIndex, nums[i]);
        }
        return maxSum;
    }
}