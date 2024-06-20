
class Solution {
    public int findLongestChain(int[][] pairs) {
        // LIS
        int n = pairs.length;
        int[] dp = new int[n+1];
        
        Arrays.sort(pairs, (p1, p2)->{
            return p1[0] - p2[0];
        });
        
        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1] && dp[j] + 1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}