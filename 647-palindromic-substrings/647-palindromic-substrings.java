class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n+1][n+1];
        int cnt = 0;
        for(int gap=0;gap<n;gap++) {
            int row = 0;
            for(int col = gap;col < n;col++) {
                if(gap == 0) 
                    dp[row][col] = true;
                else if(gap == 1)
                    dp[row][col] = s.charAt(row) == s.charAt(col);
                else 
                    dp[row][col] = s.charAt(row) == s.charAt(col) && dp[row+1][col-1];
                
                cnt += dp[row][col] == true ? 1 : 0;
                row++;
            }
        }
        return cnt;
    }
}