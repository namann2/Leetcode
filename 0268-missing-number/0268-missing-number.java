class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i = 1; i <= n; i++) {
            xor ^= i ^ nums[i-1];
        }
        return xor;
    }
}
/*
    1 3 2 0 3 1
    2 0
    2
*/