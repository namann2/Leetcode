class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // ans is the closest 3 sum value
        int n = nums.length, ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < n; i ++) {
            int j = i+1, k = n-1;
            while(j < k) {
                int curr_sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - curr_sum) < Math.abs(ans - target)) {
                    ans = curr_sum;//Math.abs(curr_sum);
                }
                if(curr_sum == target) return target;
                else if(curr_sum > target) k--;
                else j++;
            }
        }
        return ans;
    }
}