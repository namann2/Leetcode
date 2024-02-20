class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, n = nums.length;
        for(int i=1;i<=n;i++) 
            xor ^= i ^ nums[i-1];
        return xor;
    }
}