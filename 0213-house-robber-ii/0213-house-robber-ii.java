class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(maxRob(nums, 0, n-2), maxRob(nums, 1, n-1));
    }
    
    private int maxRob(int[] nums, int L, int R) {
        int r = 0, nr = 0;
        for(int i = L; i <= R; i++) {
            int cr = nums[i] + nr;
            int cnr = Math.max(r, nr);
            r = cr;
            nr = cnr;
        }
        return Math.max(r, nr);
    }
}