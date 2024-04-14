class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int csum = 0, end = 0, begin = 0, ans = 0, n = nums.length;
        while(end < n) {
            csum += nums[end];
            if(map.containsKey(csum - k)) {
                ans += map.get(csum - k);
            }
            map.put(csum, map.getOrDefault(csum, 0)+1);
            end++;
        }
        return ans;
    }
}