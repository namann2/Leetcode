class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            int j = i+1, k = n-1;
            while(j < k) {
                int csum = nums[i] + nums[j] + nums[k];
                if(Math.abs(csum - target) < Math.abs(result - target)) {
                    result = csum;
                }
                if(csum == target) {
                    return target;
                } else if(csum < target) j++;
                else k--;
            }
        }
        return result;
    }
}