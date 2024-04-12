class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length, i = 0, j = n-1;
        while(i < j) {
            int curr = nums[i] + nums[j];
            if(curr == target) return new int[]{i+1, j+1};
            else if(curr > target) j--;
            else i++;
        }
        return null;
    }
}