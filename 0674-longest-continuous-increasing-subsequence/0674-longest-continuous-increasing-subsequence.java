class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int maxLength = 1, i = 1, currLength = 1;
        while(i < n) {
            if(nums[i] > nums[i-1]) currLength++;
            else currLength = 1;
            maxLength = Math.max(maxLength, currLength);
            i++;
        }
        return maxLength;
    }
}