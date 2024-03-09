class Solution {
    public int getCommon(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(A[i] == B[j]) return A[i];
            else if(A[i] > B[j]) j++;
            else i++;
        }
        return -1;
    }
}