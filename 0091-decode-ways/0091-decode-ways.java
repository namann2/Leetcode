class Solution {
    public int numDecodings(String s) {
        // dp[i] = num of ways in which we can decode string ending at ith index
        int n = s.length();
        int[]dp = new int[n+1];
        dp[0] = 1; // empty string
        for(int i = 1; i < n+1; i++) {
            int ch = s.charAt(i-1) - '0';
            if(ch > 0 && ch < 10) dp[i] = dp[i-1];
            Integer double_digit = i-2 >= 0 ? Integer.valueOf(s.substring(i-2, i)) : 0;
            if(double_digit > 9 && double_digit < 27) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}



/* 

prev = 0

prev = 1 | 2 | 3 | 4


curr = 0 OR non-zero


*/