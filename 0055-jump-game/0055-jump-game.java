class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int canReachEndFrom = n-1;
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] + i >= canReachEndFrom) {
                canReachEndFrom = i;
            }
        }
        return canReachEndFrom == 0;
    }
}