class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer, Boolean> map = new HashMap<>();
        // first iteration
        for(int num : nums) {
            map.put(num, true);
        }
        
        // second iteration
        for(int num : map.keySet()) {
            if(map.containsKey(num - 1))
                map.put(num, false);
        }
        
        // actual length
        int maxLength = 0;
        for(int num : map.keySet()) {
            if(map.get(num) == false) continue;
            int length = 0;
            while(map.containsKey(num)) {
                num++;
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }
        
        return maxLength;
    }
}