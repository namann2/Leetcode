class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int minJump = 0, farthest = 0, currEnd = 0; // currEnd - max length/jump of current ladder/element
        for(int i = 0; i < n; i++) {
            // if we have reached the target
            if(currEnd >= n-1) return minJump;
            // keep a note of the farthest ladder
            if(i+nums[i] > farthest) {
                farthest = nums[i] + i;
            }
            // if we have exhausted our current ladder, we need to make a jump
            if(i == currEnd) {
                minJump++;
                currEnd = farthest;
            }
        }
        return minJump;
    }
}