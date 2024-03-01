class Solution {
    public int rob(int[] nums) {
        // check notes for all approach and a bonus
        int n = nums.length;
        if(n == 1) return nums[0];
        int next2 = nums[n-1];
        int next1 = Math.max(nums[n-2], next2);
        for(int i=n-3;i>=0;i--) {
            int curr = Math.max(nums[i] + next2, next1);
            next2 = next1;
            next1 = curr;
        }
        return next1;
    }
}