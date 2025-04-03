class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;
        for(int c = n-1; c >= 0; c--) {
            int a = 0, b = c-1;
            while(a < b) {
                if(nums[a] + nums[b] > nums[c]) {
                    count += b - a; // fixing b and c
                    b--; // move ahead to fix other b's and find all possible triplets
                }
                else a++; // summation is smaller hence, we need a bigger number
            }
        }
        return count;
    }
}