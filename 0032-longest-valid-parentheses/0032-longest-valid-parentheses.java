class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        int max = 0;
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') dp[i] = 2 + (i-2 >= 0 ? dp[i-2] : 0); // ()
                else { // ))
                    if(i - dp[i-1] - 1 < 0) continue;
                    if(s.charAt(i - dp[i-1] - 1) == '(')   
                        dp[i] = 2 + dp[i-1] + (i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// ( ( ( ) ) )
// 0 1 2 3 4 5
// 0 0 0 2 