class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        
        /*
            map indicates that whether current element
            can be the start of a LCS
        */
        
        Map<Integer, Boolean> map = new HashMap<>();
        
        // first pass
        for(int num : nums){
            map.put(num, true);
        }
        
        // second pass : check if current element can be the 
        // start of a LCS, one way to check this is
        // to check if current element is a part of a sequence
        
        for(int num : nums) {
            if(map.containsKey(num-1)) map.put(num, false);
        }
        
        // third pass
        int maxLength = 0;
        for(int num : nums) {
            if(!map.get(num)) continue;
            int local = 1;
            while(map.containsKey(num++ + 1)) local++;
            maxLength = Math.max(maxLength, local);
        }
        return maxLength;
    }
}