class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);
        
        int pairs = 0, n = nums.length;
        for(int num : count.keySet()) {
            int a = num;
            int b = a + k;
            if((k > 0 && count.containsKey(b)) || (k == 0 && count.get(a) >= 2))
                pairs++;
        }
        return pairs;
    }
}