class Solution {
    public int maxSubArray(int[] nums) {
        // int max = Integer.MIN_VALUE, local = 0;
        //  -2 1 -3 4 -1 2 1 -5 4
        //l -2 1 -2 4 3  5 6 1 5
        //m -2 1 1  4 4  5 6 6 6
        // for(int num : nums) {
        //     local += num; // subarray sum ending at current
        //     if(num > local) local = num; // subarray starting from current
        //     if(local > max) max = local;
        // }
        // return max;
        
        int localMax = 0, globalMax = Integer.MIN_VALUE;
        for(int num : nums) {
            localMax += num;
            localMax = Math.max(localMax, num);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}