class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for i
            int j = i + 1, k = n - 1;
            while(j < k) {
                int curr_sum = nums[i] + nums[j] + nums[k];
                if(curr_sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++; // Skip duplicates for j
                    while (j < k && nums[k] == nums[k - 1]) k--; // Skip duplicates for k
                    j++;
                    k--;
                } else if(curr_sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
