class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> {
            if(p1[0] == p2[0]) return p1[1] - p2[1];
            return p1[0] - p2[0];
        });
        
        int length = 1, n = pairs.length;
        int[]dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(pairs[j][1] < pairs[i][0] && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            length = Math.max(length, dp[i]);
        }
        return length;
    }
}