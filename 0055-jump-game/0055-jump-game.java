class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = n-1, canReachEndFrom = n-1;
        for(int standingAt = n-2; standingAt >= 0; standingAt--) {
            if(standingAt + nums[standingAt] >= canReachEndFrom) {
                canReachEndFrom = standingAt;
            }
        }
        return canReachEndFrom == 0;
    }
}