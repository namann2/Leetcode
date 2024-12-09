class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        long T = target * 1l;
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n-1; j++) {
                int left = j+1, right = n-1;
                while(left < right) {
                    long csum = nums[i] * 1l + nums[j] * 1l + nums[left] * 1l + nums[right] * 1l;
                    if(csum == T) {
                        answer.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        while(left + 1 < right && nums[left] == nums[left + 1]) left++;
                        while(right - 1 > left && nums[right] == nums[right - 1]) right --;
                        left++;
                        right--;
                    } else if(csum > T) {
                        right--;
                    } else left++;
                }
                while(j+1 < n && nums[j] == nums[j+1]) j++;
            }
        }
        return answer;
    }
}