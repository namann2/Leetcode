class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int end = 0, begin = 0, n = nums.length;
        int maxLength = 0;
        while(end < n) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            int currF = map.get(nums[end]);
            while(currF > k) {
                int bf = map.get(nums[begin]);
                map.put(nums[begin], bf - 1);
                if(nums[begin] == nums[end]) {
                    currF--;
                }
                begin++;
            }
            maxLength = Math.max(maxLength, end - begin + 1);
            end++;
        }
        return maxLength;
    }
}