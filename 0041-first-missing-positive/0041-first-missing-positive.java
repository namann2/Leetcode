class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        int i = 0;
        
        while(i < n) {
            if(A[i] <= 0 || A[i] > n) {
                i++;
            } else {
                int correctedIndex = A[i] - 1;
                if(A[i] != A[correctedIndex]) {
                    int temp = A[i];
                    A[i] = A[correctedIndex];
                    A[correctedIndex] = temp;
                }
                else i++;
            }
        }
        
        for(i = 0; i < n; i++)
            if(A[i] != i+1)
                return i+1;

        return n+1;
    }
}