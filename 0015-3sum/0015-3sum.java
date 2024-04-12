class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        
        for(int i = 0; i < n; i ++) {
            int j = i+1, k = n-1;
            while(j < k) {
                int curr_sum = nums[i] + nums[j] + nums[k];
                if(curr_sum == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(curr_sum > 0) k--;
                else j++;
            }
        }
        return new ArrayList<>(ans);
    }
}