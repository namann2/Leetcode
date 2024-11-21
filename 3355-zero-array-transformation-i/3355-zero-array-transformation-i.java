class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] line = new int[n+1];
        for(int[] query : queries) {
            line[query[0]]++;
            line[query[1]+1]--;
        }
        
        for(int i = 1; i < n+1; i++) {
            line[i] += line[i-1];
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] - line[i] > 0) return false; 
        }
        return true;
    }
}