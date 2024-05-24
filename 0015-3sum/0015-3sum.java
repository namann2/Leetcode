class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        while(i < n) {
            if(i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            int left = i + 1, right = n-1;
            while(left < right) {
                int csum = nums[i] + nums[left] + nums[right];
                if(csum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(right > left && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if(csum > 0) right--;
                else left++;
            }
            i++;
        }
        return result;
    }
}