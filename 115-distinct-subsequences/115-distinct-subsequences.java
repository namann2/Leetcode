class Solution {
    int[][]dp;
    public int numDistinct(String s, String t) {
        if(s.equals(t))
            return 1;
        int n = s.length(), m = t.length();
        dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(s, t, 0, 0, n, m);
    }
    private int solve(String s, String t, int i, int j, int n, int m) {
        // base case
        if(j == m)
            return 1;
        if(i == n)
            return j < m ? 0 : -1;
        if(dp[i][j] != -1)
            return dp[i][j];
        // main logic
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = solve(s, t, i+1, j+1, n, m) + solve(s, t, i+1, j, n, m);
        } 
        else return dp[i][j] = solve(s, t, i+1, j, n, m);
    }
}