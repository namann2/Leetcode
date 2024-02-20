class Solution {
    public int findSpecialInteger(int[] A) {
        int n = A.length, req = n / 4;
        for(int i=0;i<n;i++) {
            if(A[i] == A[i+req]) return A[i];
        }
        return -1;
    }
}