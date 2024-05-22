class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int required = target - nums[i];
            if(map.containsKey(required)) 
                return new int[]{map.get(required), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}