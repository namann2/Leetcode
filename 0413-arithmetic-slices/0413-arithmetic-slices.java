class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n < 3) return 0;
        // number of arithmetic subsequences considering A[i] 
        // as the middle element of the subsequence
        int []dp = new int[n];
        for(int i=1;i<n-1;i++)
            if(A[i]-A[i-1] == A[i+1]-A[i])
                dp[i] = 1 + dp[i-1];
        return Arrays.stream(dp).sum();
    }
}