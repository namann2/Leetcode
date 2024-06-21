class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            //  1 2 3
            if(nums[i] <= 0 || nums[i] > n) continue;
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp; // correctIndex is now updated with correct element
                i--; // ith index is not at correct position
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] != i+1) return i+1;
        }
        
        return n+1;
    }
}