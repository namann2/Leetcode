class Solution {
    public int findMin(int[] A) {
        int n = A.length;
        
        if(n==1) return A[0];
        // no rotation
        if(A[0] < A[n-1]) 
            return A[0];
        
        int start = 0, end = n-1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mid-1 >= 0 && A[mid] < A[mid-1]) return A[mid];
            else if(mid+1 < n && A[mid] > A[mid+1]) return A[mid+1];
            else if(A[mid] > A[start]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}