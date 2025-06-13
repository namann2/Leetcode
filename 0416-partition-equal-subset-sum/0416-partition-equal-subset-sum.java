class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if((sum & 1) == 1) return false;
        int n = nums.length, T = sum / 2;
        // bottom up
        // step1 : base case
        boolean[] prev = new boolean[T+1];
        
        prev[0] = true;
        for(int target = 0; target < T + 1; target++) {
            if(nums[0] == target) prev[target] = true;
        }

        // step2 : iteration
        for(int index = 1; index < n; index ++) {
            boolean[] curr = new boolean[T+1];
            for(int target = 0; target < T + 1; target++) {
                boolean skip = prev[target];
                boolean take = false;
                if(nums[index] <= target) {
                    take = prev[target - nums[index]];
                } 
                curr[target] = take || skip;
            }
            prev = curr;
        }
        return prev[T];
    }
}