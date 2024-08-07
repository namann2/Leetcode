class Solution {
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length(), m = B.length();
        int[]next = new int[m+1];
        for(int i = n-1; i >= 0; i--) {
            int[] curr = new int[m+1];
            for(int j = m-1; j >= 0; j--) {
                if(A.charAt(i) == B.charAt(j))
                    curr[j] = 1 + next[j+1];
                else curr[j] = Math.max(next[j], curr[j+1]);
            }
            next = curr;
        }
        return next[0];
    }
}