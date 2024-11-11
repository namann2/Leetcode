class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        int[] bits = new int[32];
        for(int candidate : candidates) {
            for(int i = 0; i < 32; i++) {
                int currBit = ((candidate >> i) & 1);
                bits[i] += currBit;
                // ans = Math.max(ans, bits[i]);
            }
        }
        
        for(int i = 0; i < 32; i++) {
            ans = Math.max(ans, bits[i]);
        }
        
        return ans;
    }
}