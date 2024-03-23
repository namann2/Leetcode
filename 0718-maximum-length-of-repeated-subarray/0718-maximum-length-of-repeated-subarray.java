class Solution {
    public int findLength(int[] A, int[] B) {
        // Hint : Subarray/Substring + common in both 
        // we need to find common substring
        int n = A.length, m = B.length;
        int maxLength = 0;
        for(int i = 0; i <= n + m - 2; i++) {
            int aStart = Math.max(0, n - 1 - i);
            int bStart = Math.max(0, i - (m - 1));
            int currLength = 0;
            /*
                The current overlapping window is 
                A[aStart, Math.min(A.length, B.length)] and 
                B[bStart, Math.min(A.length, B.length)].
            */
            for(;aStart < n && bStart < m; aStart++, bStart++) {
                if(A[aStart] == B[bStart])
                    currLength++;
                else currLength = 0;
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }
}