class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i=1;i<n;i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        
        int max = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            if(min[i] < nums[i] && nums[i] < max) return true;
            max = Math.max(max, nums[i]);
        }
        return false;
    }
}