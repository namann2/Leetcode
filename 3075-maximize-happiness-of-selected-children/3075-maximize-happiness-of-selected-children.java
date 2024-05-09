class Solution {
    public long maximumHappinessSum(int[] A, int k) {
        long ans = 0;
        Arrays.sort(A);
        
        int n = A.length;
        int turn = 0;
        for(int i = n-1; i >= 0 && k-- > 0; i--) {
            ans += Math.max(0, A[i] - turn++);
        }
        return ans;
    }
}