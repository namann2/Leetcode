class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int n = nums.length;
        int voteCount = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] == majorityElement) ++voteCount;
            else voteCount--;
            if(voteCount == 0) {
                majorityElement = nums[i];
                voteCount = 1;
            }
        }
        return majorityElement;
    }
}