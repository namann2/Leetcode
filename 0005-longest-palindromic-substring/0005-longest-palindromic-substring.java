class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n+1][n+1];
        int start = 0, end = 0;
        for(int gap = 0; gap < n; gap++) {
            int row = 0;
            for(int col = gap; col < n ; col++) {
                if(gap == 0) dp[row][col] = true;
                else if(gap == 1) dp[row][col] = s.charAt(row) == s.charAt(col);
                else dp[row][col] = s.charAt(row) == s.charAt(col) && dp[row+1][col-1];
                
                if(dp[row][col]) {
                    start = row;
                    end = col;
                }
                row++;
            }
        }
        return s.substring(start, end + 1);
    }
}