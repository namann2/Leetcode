enum BOUND {
    LOWER, UPPER;
}
class Solution {
    // https://www.youtube.com/watch?v=6BoymP9R9MM
    public int findSpecialInteger(int[] A) {
        int n = A.length;
        int[] B = {n/4, n/2, 3*n/4};
        for(int b : B) {
            int start = bs(A, A[b], 0, b, BOUND.LOWER);
            int end = bs(A, A[b], b, n-1, BOUND.UPPER);
            if(end-start+1 > n/4)
                return A[b];
        }
        return -1;
    }
    private int bs(int[] A, int target, int start, int end, BOUND bound) {
        int ans = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(A[mid] == target) {
                ans = mid;
                if(bound == BOUND.LOWER) end = mid - 1;
                else start = mid + 1;
            } else if(A[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return ans;
    }
    
}