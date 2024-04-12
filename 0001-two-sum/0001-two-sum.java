class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n; i++) {
            int curr = target - nums[i];
            if(map.containsKey(curr)) return new int[]{i, map.get(curr)};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}