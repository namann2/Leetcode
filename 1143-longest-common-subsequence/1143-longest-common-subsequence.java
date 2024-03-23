class Solution {
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length(), m = B.length();
        if(m > n)
            return longestCommonSubsequence(B, A);
        
        int[]next = new int[n+1];
        
        for(int i = n-1; i >= 0 ; i--) {
            int [] curr = new int[n+1];
            for(int j = m-1; j >= 0; j--) {
                if(A.charAt(i) == B.charAt(j)) 
                    // dp[i][j] = 1 + dp[i+1][j+1];
                    curr[j] = 1 + next[j+1];
                else 
                    // dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    curr[j] = Math.max(next[j], curr[j+1]);
            }
            next = curr;
        }
        
        return next[0];
        
        /*
        StringBuilder ans = new StringBuilder();
        int i = n-1, j = m-1;
        while(i >= 0 && j >= 0) {
            if(A.charAt(i) == B.charAt(j)) {
                ans.append(A.charAt(i));
                i--;
                j--;
            } else {
                if(dp[i+1][j] > dp[i][j+1]) j--;
                else i--;
            }
        }
        ans = ans.reverse();
        System.out.println(ans);
        */
        // return dp[0][0];
    }
}