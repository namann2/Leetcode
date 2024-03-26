class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        int i=0;
        while(i < n) {
            if(A[i] < 0) {
                i++;
                continue;
            }
            int correctIndex = A[i] - 1;
            if(correctIndex >= 0 && correctIndex < n && A[correctIndex] != A[i]) {
                int tmp = A[correctIndex];
                A[correctIndex] = A[i];
                A[i] = tmp;
            } else i++;
        }
        
        for(i=0;i<n;i++) {
            if(i+1 != A[i]) return i+1;
        }
        return n+1;
    }
}