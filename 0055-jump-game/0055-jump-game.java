class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastGoodPosition = n-1;
        for(int i=n-2;i>=0;i--) {
            if(nums[i] + i >= lastGoodPosition)
                lastGoodPosition = i;
        }
        return lastGoodPosition == 0;
    }
}