class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length, m = B.length;
        if(n > m)
            return findMedianSortedArrays(B, A);
        
        int total = n + m;
        int half = (total + 1)/2;
        
        int start = 0, end = n;
        
        while(start <= end) {
            int pA = start + (end - start) / 2;
            int pB = half - pA; 
            
            int l1 = pA - 1 >= 0 ? A[pA-1] : Integer.MIN_VALUE;
            int l2 = pB - 1 >= 0 ? B[pB-1] : Integer.MIN_VALUE;
            
            int r1 = pA < n ? A[pA] : Integer.MAX_VALUE;
            int r2 = pB < m ? B[pB] : Integer.MAX_VALUE;
            
            if(l1 <= r2 && l2 <= r1) {
                int maxLeft = Math.max(l1, l2);
                if(total % 2 == 0) {
                    int minRight = Math.min(r1, r2);
                    return (maxLeft + minRight) / 2.0;
                } 
                return maxLeft * 1.0;
            } else if(l2 > r1) start = pA + 1;
            else end = pA - 1;
        }
        return 0.0;
    }
}