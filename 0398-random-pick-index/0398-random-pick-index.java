// Apply reservoir sampling on target index
class Solution {
    int nums[];
    int n;
    public Solution(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
    }
    
    public int pick(int target) {
        int ans = -1, seen = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                ++seen;
                int randomIndex = (int)(Math.random() * seen);
                if(randomIndex == seen - 1)
                    ans = i;
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */