class Solution {
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length(), m = B.length();
        int[][]dp = new int[n+1][m+1];
        
        dp[n][m] = 0;
        for(int si = n - 1; si >= 0; si--) {
            for(int pi = m - 1; pi >= 0; pi--) {
                if(A.charAt(si) == B.charAt(pi)) {
                    dp[si][pi] = 1 + dp[si+1][pi+1];
                } else
                    dp[si][pi] = Math.max(dp[si+1][pi], dp[si][pi+1]);
            }
        }
        // return dp[0][0];
        
        StringBuffer answer = new StringBuffer();
        int i = n-1, j = m-1;
        while(i >= 0 && j >= 0) {
            if(A.charAt(i) == B.charAt(j)) {
                answer.append(A.charAt(i));
                i--;
                j--;
            } else {
                if(dp[i+1][j] > dp[i][j+1]) i--;
                else j--;
            }
        }
        
        System.out.println(answer.reverse().toString());
        return dp[0][0];
    }
}