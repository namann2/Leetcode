class Solution {
    public int longestCommonSubsequence(String w1, String w2) {
        int w1Length = w1.length(), w2Length = w2.length();
        Integer[][]dp = new Integer[w1Length][w2Length];
        return lcs(w1, w2, w1Length - 1, w2Length - 1, dp);
    }

    // helper function
    private int lcs(String w1, String w2, int index1, int index2, Integer[][] dp) {
        // base case
        if(index1 == 0 && index2 == 0) return w1.charAt(0) == w2.charAt(0) ? 1 : 0;
        if(index1 < 0 || index2 < 0) return 0;
        if(dp[index1][index2] != null) 
            return dp[index1][index2];
        // main logic
        if(w1.charAt(index1) == w2.charAt(index2)) {
            return dp[index1][index2] = 1 + lcs(w1, w2, index1 - 1, index2 - 1, dp);
        } else {
            int op1 = lcs(w1, w2, index1 - 1, index2, dp);
            int op2 = lcs(w1, w2, index1, index2 - 1, dp);
            return dp[index1][index2] = Math.max(op1, op2);
        }
    }
}