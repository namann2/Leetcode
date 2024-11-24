class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, qL = queries.length;
        if(Arrays.stream(nums).sum() == 0) return 0;
        int start = 0, end = qL - 1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            boolean isZeroCount = zeroArray(nums, queries, mid);
            if(isZeroCount) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans == -1 ? -1 : ans + 1;
    }
    
    private boolean zeroArray(int[] nums, int[][] queries, int k) {
        int n = nums.length, qL = queries.length;
        int[] line = new int[n + 1];
        
        for(int i = 0; i <= k; i++) {
            int startIndex = queries[i][0], endIndex = queries[i][1], value = queries[i][2];
            line[startIndex] -= value;
            line[endIndex + 1] += value;
        }
        
        for(int i = 1; i < n+1; i++) {
            line[i] += line[i-1];
        }
        
        for(int i = 0; i < n; i++) {
            if(line[i] + nums[i] > 0) return false;
        }
        
        return true;
    }
}