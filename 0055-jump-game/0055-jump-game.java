/*

Much simpler and better solution : 
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for(int i = 0; i <= farthest && i < n; i++) {
            if(i + nums[i] > farthest) {
                farthest = i + nums[i];
            }
        }
        return farthest >= n-1;
    }
}
*/

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
