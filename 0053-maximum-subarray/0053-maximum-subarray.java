class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, local = 0;
        for(int num : nums) {
            local += num;
            if(num > local) local = num;
            if(local > max) max = local;
        }
        return max;
    }
}