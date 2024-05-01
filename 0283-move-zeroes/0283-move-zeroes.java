class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, i = 0;
        for(int j = 0; j < n; j++)
            if(nums[j] != 0)
                nums[i++] = nums[j];
        for(;i<n;i++)
            nums[i] = 0;
    }
}