class Solution {
    public int longestNiceSubarray(int[] A) {
        // since we are given positive integers, thus we can use sliding window
        int n = A.length;
        int ans = 1;
        int begin = 0, end = 0;
        int mask = 0; // set bits of all numbers in window
        while(end < n) {
            
            while((mask&A[end]) != 0 && begin<end)
                mask ^= A[begin++];
            
            // set all bits of A[end];
            mask |= A[end];
            ans = Math.max(ans, end - begin + 1);
            end++;
        }
        return ans;
    }
}
/*
    1, 3, 8, 48, 10
    
*/