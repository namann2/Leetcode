class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length;
        int sum = 0, ans = 0;
        
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int req = sum - k;
            if(map.containsKey(req)) ans += map.get(req);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

//   1 1 1, k = 2
// 0 1 2 3

// ans = 0,1
// map {0 : 1, 1 : 1}