class Solution {
    public int minOperations(int[] A) {
        int n = A.length;
        int moves = 0;
        for(int i=1;i<n;i++)
        {
            if(A[i] > A[i-1]) continue;
            int diff = A[i-1] - A[i];
            int newValue = diff + 1;
            moves += newValue;
            A[i] += newValue;
        }
        return moves;
    }
}