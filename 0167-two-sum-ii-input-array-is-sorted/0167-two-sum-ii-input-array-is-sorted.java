class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n  = nums.length, left = 0, right = n - 1;
        while(left < right) {
            int csum = nums[left] + nums[right];
            if(csum == target) return new int[]{left + 1, right + 1};
            else if(csum > target) right--;
            else left++;
        }
        return new int[]{-1,-1};
    }
}