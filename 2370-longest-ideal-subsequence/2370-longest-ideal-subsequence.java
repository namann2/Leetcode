class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length(), maxLength = 0;
        int[]dp = new int[26];
        for(int i = 0; i < n; i++) {
            int ch1 = s.charAt(i) - 'a';
            for(int j = Math.max(ch1 - k, 0); j <= Math.min(25, ch1 + k); j++) {
                dp[ch1] = Math.max(dp[ch1], dp[j]);
            }
            dp[ch1]++;
            maxLength = Math.max(maxLength, dp[ch1]);
        }
        return maxLength;
    }
}