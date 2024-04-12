class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length, ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n; i ++) {
            int j = i+1, k = n-1;
            while(j < k) {
                int curr_sum = nums[i] + nums[j] + nums[k];
                if(curr_sum >= target) k--;
                else {
                    ans += k - j;
                    j++;
                }
            }
        }
        return ans;
    }
}