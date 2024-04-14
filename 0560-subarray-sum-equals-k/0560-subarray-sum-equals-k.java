class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, csum = 0;
        map.put(0, 1);
        for(int num : nums) {
            csum += num;
            if(map.containsKey(csum - k)) {
                cnt += map.get(csum - k);
            }
            map.put(csum, map.getOrDefault(csum, 0) + 1);
        }
        return cnt;
    }
}