class Solution {
    public void merge(int[] A, int n, int[] B, int m) {
        int p = n-1, q = m-1, l = A.length - 1;
        while(p >= 0 && q >= 0) {
            if(A[p] >= B[q]) {
                A[l--] = A[p--];
            } else {
                A[l--] = B[q--];
            }
        }
        
        while(p >= 0) A[l--] = A[p--];
        while(q >= 0) A[l--] = B[q--];
    }
}