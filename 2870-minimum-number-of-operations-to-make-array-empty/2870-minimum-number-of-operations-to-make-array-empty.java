class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int operations = 0;
        for(int num : count.keySet()) {
            int freq = count.get(num);
            if(freq == 1) return -1;
            operations += freq / 3 + (freq % 3 > 0 ? 1 : 0);
        }
        return operations;
    }
}

// {2 : 4, 3 : 3, 4 : 2}
// 2 + 1 + 1