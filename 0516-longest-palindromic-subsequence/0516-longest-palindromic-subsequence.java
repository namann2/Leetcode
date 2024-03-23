class Solution {
    public int longestPalindromeSubseq(String A) {
        int n = A.length();
        String B = new StringBuilder(A).reverse().toString();
        int[]next = new int[n+1];
        for(int i = n-1; i>= 0; i--) {
            int[]curr = new int[n+1];
            for(int j = n-1; j >= 0; j--) {
                if(A.charAt(i) == B.charAt(j)) {
                    curr[j] = 1 + next[j+1];
                } else {
                    curr[j] = Math.max(next[j], curr[j+1]);
                }
            }
            next = curr;
        }
        return next[0];
    }
}