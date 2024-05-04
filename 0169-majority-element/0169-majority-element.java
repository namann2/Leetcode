class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int voteCount = 1;
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[i] == majorityElement) voteCount++;
            else voteCount--;
            if(voteCount == 0) {
                voteCount = 1;
                majorityElement = nums[i];
            }
        }
        return majorityElement;
    }
}