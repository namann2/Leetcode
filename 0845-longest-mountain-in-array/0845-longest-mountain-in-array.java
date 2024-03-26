class Solution {
    public int longestMountain(int[] A) {
        // Check Notes : For intuitive and TC = SC = O(n) solution.
        // follow-up Solution. 
        int n = A.length;
        int max = 0, i = 1;
        
        while(i<n) {
            int up = 0, down = 0;
            while(i<n && A[i] > A[i-1]) {
                i++;
                up++;
            }
            while(i<n && A[i] < A[i-1]) {
                i++;
                down++;
            }
            
            if(up > 0 && down > 0)
                max = Math.max(max, up + down + 1) ;
            
            // now we would either be having a uphill or a flat
            while(i<n && A[i] == A[i-1]) i++;
        }
        
        return max;
    }
}