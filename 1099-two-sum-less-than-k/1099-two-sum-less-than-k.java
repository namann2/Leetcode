class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n-1, max = -1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < k) {
                max = Math.max(max, sum);
                left++;
            } else right--;
        }
        return max;
    }
}